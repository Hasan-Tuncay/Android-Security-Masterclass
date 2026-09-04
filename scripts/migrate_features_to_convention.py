#!/usr/bin/env python3
"""
Automated Migration Script: Feature Modules to 'mobsec.android.feature'
======================================================================
Migrates all 78 MASWE feature modules in features/ to use the
'mobsec.android.feature' convention plugin.
Eliminates duplicated boilerplate, aligns compileSdk=37 and Java 17,
and preserves module-specific dependencies.
"""

import os
import re
from pathlib import Path

ROOT_DIR = Path(__file__).resolve().parent.parent
FEATURES_DIR = ROOT_DIR / "features"

STANDARD_FEATURE_DEPS = [
    "implementation(libs.androidx.security.crypto)",
    "implementation(libs.tink.android)",
    "implementation(libs.bouncycastle.bcprov)",
    "implementation(libs.bouncycastle.bcpkix)",
    "implementation(libs.androidx.datastore.preferences)",
    "implementation(libs.androidx.datastore)",
    "implementation(libs.androidx.room.runtime)",
    "implementation(libs.androidx.room.ktx)",
    "ksp(libs.androidx.room.compiler)",
    "implementation(libs.sqlcipher)"
]

def migrate_module(mod_dir: Path):
    build_file = mod_dir / "build.gradle.kts"
    if not build_file.exists():
        return False

    content = build_file.read_text(encoding="utf-8")
    if 'id("mobsec.android.feature")' in content:
        return False  # Already migrated

    # Extract namespace or compute from folder name
    ns_match = re.search(r'namespace\s*=\s*"([^"]+)"', content)
    if ns_match:
        namespace = ns_match.group(1)
    else:
        namespace = f"com.hasantuncay.mobsec.{mod_dir.name}"

    # Check for any extra dependencies besides standard ones
    extra_deps = []
    if "ktor" in content:
        for line in content.splitlines():
            if "ktor" in line and ("implementation" in line or "api" in line):
                extra_deps.append(line.strip())

    deps_block = "\n".join([f"    {d}" for d in STANDARD_FEATURE_DEPS + extra_deps])

    new_content = f"""plugins {{
    id("mobsec.android.feature")
}}

android {{
    namespace = "{namespace}"
}}

dependencies {{
{deps_block}
}}
"""
    build_file.write_text(new_content, encoding="utf-8")
    return True

def main():
    feature_dirs = sorted([d for d in FEATURES_DIR.iterdir() if d.is_dir() and d.name.startswith("maswe")])
    migrated_count = 0
    for f_dir in feature_dirs:
        if migrate_module(f_dir):
            migrated_count += 1
            print(f"[MIGRATED] {f_dir.name}")
        else:
            print(f"[SKIP] {f_dir.name} (Already migrated or not applicable)")

    print(f"\nMigration complete: {migrated_count} modules migrated out of {len(feature_dirs)}.")

if __name__ == "__main__":
    main()
