import os
import shutil

ROOT = "/Users/PROJECTS_ALL/Appfiliate/AndroidSecurityMasterclass"

MAPPINGS = {
    "0001": "storage", "0002": "storage", "0003": "storage", "0004": "storage", "0005": "storage", "0006": "storage",
    "0007": "crypto", "0008": "crypto", "0009": "crypto", "0010": "crypto", "0011": "crypto",
    "0012": "crypto", "0013": "crypto", "0014": "crypto", "0015": "crypto", "0016": "crypto", "0017": "crypto",
    "0018": "auth", "0019": "auth", "0020": "auth", "0021": "auth", "0022": "auth",
    "0023": "auth", "0024": "auth", "0025": "auth",
    "0026": "network", "0027": "network", "0028": "network"
}

def fix_app(app_type):
    # app_type: "vulnerable" or "secure"
    if app_type == "vulnerable":
        base_dir = os.path.join(ROOT, "app-vulnerable/src/main/java/com/hasantuncay/mobsec")
        src_package_base = "com.hasantuncay.mobsec"
    else:
        base_dir = os.path.join(ROOT, "app-secure/src/main/java/com/hasantuncay/mobsec/secure")
        src_package_base = "com.hasantuncay.mobsec.secure"
        
    storage_dir = os.path.join(base_dir, "storage")
    
    if not os.path.exists(storage_dir):
        return

    for folder in os.listdir(storage_dir):
        if not folder.startswith("maswe"):
            continue
            
        maswe_num = folder[-4:]
        target_category = MAPPINGS.get(maswe_num)
        
        if not target_category or target_category == "storage":
            continue
            
        old_dir = os.path.join(storage_dir, folder)
        new_dir = os.path.join(base_dir, target_category, folder)
        
        os.makedirs(new_dir, exist_ok=True)
        
        # move files
        for f in os.listdir(old_dir):
            if f.endswith(".kt"):
                old_file = os.path.join(old_dir, f)
                new_file = os.path.join(new_dir, f)
                shutil.move(old_file, new_file)
                
                # Update package inside file
                with open(new_file, 'r') as fp:
                    content = fp.read()
                
                old_pkg = f"package {src_package_base}.storage.{folder}"
                new_pkg = f"package {src_package_base}.{target_category}.{folder}"
                
                content = content.replace(old_pkg, new_pkg)
                
                with open(new_file, 'w') as fp:
                    fp.write(content)
                    
        # remove old dir if empty
        if not os.listdir(old_dir):
            os.rmdir(old_dir)
            
    # Fix MainActivity
    main_activity_path = os.path.join(ROOT, f"app-{app_type}/src/main/java/com/hasantuncay/mobsec", "MainActivity.kt")
    if app_type == "secure":
        main_activity_path = os.path.join(ROOT, "app-secure/src/main/java/com/hasantuncay/mobsec/secure", "MainActivity.kt")
        
    if os.path.exists(main_activity_path):
        with open(main_activity_path, 'r') as fp:
            content = fp.read()
            
        for maswe_num, category in MAPPINGS.items():
            if category == "storage":
                continue
            folder = f"maswe{maswe_num}"
            old_import = f"import {src_package_base}.storage.{folder}"
            new_import = f"import {src_package_base}.{category}.{folder}"
            content = content.replace(old_import, new_import)
            
        with open(main_activity_path, 'w') as fp:
            fp.write(content)

fix_app("vulnerable")
fix_app("secure")
print("Done.")
