STRINGS = """
    <!-- MASWE-0041 to MASWE-0050 Titles -->
    <string name="maswe_0041_id">MASWE-0041</string>
    <string name="maswe_0041_title">Running on a Recent Platform Version Not Ensured</string>
    <string name="maswe_0042_id">MASWE-0042</string>
    <string name="maswe_0042_title">Latest Platform Version Not Targeted</string>
    <string name="maswe_0043_id">MASWE-0043</string>
    <string name="maswe_0043_title">Enforced Updating Not Implemented</string>
    <string name="maswe_0044_id">MASWE-0044</string>
    <string name="maswe_0044_title">Dependencies with Known Vulnerabilities</string>
    <string name="maswe_0045_id">MASWE-0045</string>
    <string name="maswe_0045_title">Compiler-Provided Security Features Not Used</string>
    <string name="maswe_0046_id">MASWE-0046</string>
    <string name="maswe_0046_title">Use of Deprecated APIs or Functionality</string>
    <string name="maswe_0047_id">MASWE-0047</string>
    <string name="maswe_0047_title">Using Non-Standard APIs for Security-Critical Functionality</string>
    <string name="maswe_0048_id">MASWE-0048</string>
    <string name="maswe_0048_title">Malicious Code Included in the App</string>
    <string name="maswe_0049_id">MASWE-0049</string>
    <string name="maswe_0049_title">Unsafe Dynamic Code Loading</string>
    <string name="maswe_0050_id">MASWE-0050</string>
    <string name="maswe_0050_title">Unsafe Handling of Untrusted Data</string>

    <!-- MASWE-0041 Vectors -->
    <string name="maswe_0041_vector_low_min_version_modern_assumptions_vuln">1. Low Min Version Modern Assumptions</string>
    <string name="maswe_0041_vector_low_min_version_modern_assumptions_secure">1. Secure: Min Version Verified</string>
    <string name="maswe_0041_msg_low_min_version_modern_assumptions_vuln">Vulnerable description</string>
    <string name="maswe_0041_msg_low_min_version_modern_assumptions_secure">Secure description</string>
    <string name="maswe_0041_vector_known_vulnerable_platform_supported_vuln">2. Known Vulnerable Platform Supported</string>
    <string name="maswe_0041_vector_known_vulnerable_platform_supported_secure">2. Secure: Unsupported on Vulnerable Platforms</string>
    <string name="maswe_0041_msg_known_vulnerable_platform_supported_vuln">Vulnerable description</string>
    <string name="maswe_0041_msg_known_vulnerable_platform_supported_secure">Secure description</string>

    <!-- MASWE-0042 Vectors -->
    <string name="maswe_0042_vector_outdated_target_version_vuln">1. Outdated Target Version</string>
    <string name="maswe_0042_vector_outdated_target_version_secure">1. Secure: Latest SDK Targeted</string>
    <string name="maswe_0042_msg_outdated_target_version_vuln">Vulnerable description</string>
    <string name="maswe_0042_msg_outdated_target_version_secure">Secure description</string>
    <string name="maswe_0042_vector_compatibility_behaviors_left_vuln">2. Compatibility Behaviors Left in Place</string>
    <string name="maswe_0042_vector_compatibility_behaviors_left_secure">2. Secure: Legacy Behaviors Removed</string>
    <string name="maswe_0042_msg_compatibility_behaviors_left_vuln">Vulnerable description</string>
    <string name="maswe_0042_msg_compatibility_behaviors_left_secure">Secure description</string>

    <!-- MASWE-0043 Vectors -->
    <string name="maswe_0043_vector_no_enforced_update_mechanism_vuln">1. No Enforced Update Mechanism</string>
    <string name="maswe_0043_vector_no_enforced_update_mechanism_secure">1. Secure: In-App Updates Enforced</string>
    <string name="maswe_0043_msg_no_enforced_update_mechanism_vuln">Vulnerable description</string>
    <string name="maswe_0043_msg_no_enforced_update_mechanism_secure">Secure description</string>

    <!-- MASWE-0044 Vectors -->
    <string name="maswe_0044_vector_direct_dependencies_vuln">1. Direct Dependencies</string>
    <string name="maswe_0044_vector_direct_dependencies_secure">1. Secure: Safe Dependencies</string>
    <string name="maswe_0044_msg_direct_dependencies_vuln">Vulnerable description</string>
    <string name="maswe_0044_msg_direct_dependencies_secure">Secure description</string>
    <string name="maswe_0044_vector_transitive_dependencies_vuln">2. Transitive Dependencies</string>
    <string name="maswe_0044_vector_transitive_dependencies_secure">2. Secure: Safe Transitive Dependencies</string>
    <string name="maswe_0044_msg_transitive_dependencies_vuln">Vulnerable description</string>
    <string name="maswe_0044_msg_transitive_dependencies_secure">Secure description</string>
    <string name="maswe_0044_vector_dynamically_loaded_dependencies_vuln">3. Dynamically Loaded Dependencies</string>
    <string name="maswe_0044_vector_dynamically_loaded_dependencies_secure">3. Secure: Verified Plugins</string>
    <string name="maswe_0044_msg_dynamically_loaded_dependencies_vuln">Vulnerable description</string>
    <string name="maswe_0044_msg_dynamically_loaded_dependencies_secure">Secure description</string>
    <string name="maswe_0044_vector_outdated_platform_security_components_vuln">4. Outdated Platform Security Components</string>
    <string name="maswe_0044_vector_outdated_platform_security_components_secure">4. Secure: Security Provider Updated</string>
    <string name="maswe_0044_msg_outdated_platform_security_components_vuln">Vulnerable description</string>
    <string name="maswe_0044_msg_outdated_platform_security_components_secure">Secure description</string>
    <string name="maswe_0044_vector_usage_of_third_party_frameworks_vuln">5. Third-Party Framework Vulns</string>
    <string name="maswe_0044_vector_usage_of_third_party_frameworks_secure">5. Secure: Updated Framework</string>
    <string name="maswe_0044_msg_usage_of_third_party_frameworks_vuln">Vulnerable description</string>
    <string name="maswe_0044_msg_usage_of_third_party_frameworks_secure">Secure description</string>

    <!-- MASWE-0045 Vectors -->
    <string name="maswe_0045_vector_missing_stack_protection_vuln">1. Missing Stack Protection</string>
    <string name="maswe_0045_vector_missing_stack_protection_secure">1. Secure: Stack Canaries Enabled</string>
    <string name="maswe_0045_msg_missing_stack_protection_vuln">Vulnerable description</string>
    <string name="maswe_0045_msg_missing_stack_protection_secure">Secure description</string>
    <string name="maswe_0045_vector_missing_pie_aslr_support_vuln">2. Missing PIE/ASLR Support</string>
    <string name="maswe_0045_vector_missing_pie_aslr_support_secure">2. Secure: PIE Enabled</string>
    <string name="maswe_0045_msg_missing_pie_aslr_support_vuln">Vulnerable description</string>
    <string name="maswe_0045_msg_missing_pie_aslr_support_secure">Secure description</string>
    <string name="maswe_0045_vector_missing_fortified_functions_vuln">3. Missing Fortified Functions</string>
    <string name="maswe_0045_vector_missing_fortified_functions_secure">3. Secure: Fortify Source Enabled</string>
    <string name="maswe_0045_msg_missing_fortified_functions_vuln">Vulnerable description</string>
    <string name="maswe_0045_msg_missing_fortified_functions_secure">Secure description</string>
    <string name="maswe_0045_vector_unsafe_memory_management_choices_vuln">4. Unsafe Memory Management</string>
    <string name="maswe_0045_vector_unsafe_memory_management_choices_secure">4. Secure: Memory Safe Defaults</string>
    <string name="maswe_0045_msg_unsafe_memory_management_choices_vuln">Vulnerable description</string>
    <string name="maswe_0045_msg_unsafe_memory_management_choices_secure">Secure description</string>

    <!-- MASWE-0046 Vectors -->
    <string name="maswe_0046_vector_deprecated_cryptographic_providers_vuln">1. Deprecated Crypto Providers</string>
    <string name="maswe_0046_vector_deprecated_cryptographic_providers_secure">1. Secure: Maintained Providers</string>
    <string name="maswe_0046_msg_deprecated_cryptographic_providers_vuln">Vulnerable description</string>
    <string name="maswe_0046_msg_deprecated_cryptographic_providers_secure">Secure description</string>
    <string name="maswe_0046_vector_deprecated_platform_apis_vuln">2. Deprecated Platform APIs</string>
    <string name="maswe_0046_vector_deprecated_platform_apis_secure">2. Secure: Modern Alternatives Used</string>
    <string name="maswe_0046_msg_deprecated_platform_apis_vuln">Vulnerable description</string>
    <string name="maswe_0046_msg_deprecated_platform_apis_secure">Secure description</string>
    <string name="maswe_0046_vector_deprecation_warnings_ignored_vuln">3. Deprecation Warnings Ignored</string>
    <string name="maswe_0046_vector_deprecation_warnings_ignored_secure">3. Secure: No Deprecation Warnings</string>
    <string name="maswe_0046_msg_deprecation_warnings_ignored_vuln">Vulnerable description</string>
    <string name="maswe_0046_msg_deprecation_warnings_ignored_secure">Secure description</string>

    <!-- MASWE-0047 Vectors -->
    <string name="maswe_0047_vector_roll_your_own_cryptography_vuln">1. Roll-Your-Own Cryptography</string>
    <string name="maswe_0047_vector_roll_your_own_cryptography_secure">1. Secure: Standard Cryptography</string>
    <string name="maswe_0047_msg_roll_your_own_cryptography_vuln">Vulnerable description</string>
    <string name="maswe_0047_msg_roll_your_own_cryptography_secure">Secure description</string>
    <string name="maswe_0047_vector_custom_networking_tls_stacks_vuln">2. Custom Networking/TLS Stacks</string>
    <string name="maswe_0047_vector_custom_networking_tls_stacks_secure">2. Secure: Proven Network APIs</string>
    <string name="maswe_0047_msg_custom_networking_tls_stacks_vuln">Vulnerable description</string>
    <string name="maswe_0047_msg_custom_networking_tls_stacks_secure">Secure description</string>
    <string name="maswe_0047_vector_custom_dns_resolution_vuln">3. Custom DNS Resolution</string>
    <string name="maswe_0047_vector_custom_dns_resolution_secure">3. Secure: Secure Name Resolution</string>
    <string name="maswe_0047_msg_custom_dns_resolution_vuln">Vulnerable description</string>
    <string name="maswe_0047_msg_custom_dns_resolution_secure">Secure description</string>
    <string name="maswe_0047_vector_custom_authentication_vuln">4. Custom Authentication</string>
    <string name="maswe_0047_vector_custom_authentication_secure">4. Secure: Platform Authentication APIs</string>
    <string name="maswe_0047_msg_custom_authentication_vuln">Vulnerable description</string>
    <string name="maswe_0047_msg_custom_authentication_secure">Secure description</string>
    <string name="maswe_0047_vector_unmaintained_security_libraries_vuln">5. Unmaintained Security Libraries</string>
    <string name="maswe_0047_vector_unmaintained_security_libraries_secure">5. Secure: Maintained Libraries</string>
    <string name="maswe_0047_msg_unmaintained_security_libraries_vuln">Vulnerable description</string>
    <string name="maswe_0047_msg_unmaintained_security_libraries_secure">Secure description</string>

    <!-- MASWE-0048 Vectors -->
    <string name="maswe_0048_vector_malicious_developer_vuln">1. Malicious Developer</string>
    <string name="maswe_0048_vector_malicious_developer_secure">1. Secure: Code Review Enforced</string>
    <string name="maswe_0048_msg_malicious_developer_vuln">Vulnerable description</string>
    <string name="maswe_0048_msg_malicious_developer_secure">Secure description</string>
    <string name="maswe_0048_vector_compromised_dependencies_vuln">2. Compromised Dependencies</string>
    <string name="maswe_0048_vector_compromised_dependencies_secure">2. Secure: Software Supply Chain Security</string>
    <string name="maswe_0048_msg_compromised_dependencies_vuln">Vulnerable description</string>
    <string name="maswe_0048_msg_compromised_dependencies_secure">Secure description</string>
    <string name="maswe_0048_vector_compromised_build_pipeline_vuln">3. Compromised Build Pipeline</string>
    <string name="maswe_0048_vector_compromised_build_pipeline_secure">3. Secure: Secured CI/CD</string>
    <string name="maswe_0048_msg_compromised_build_pipeline_vuln">Vulnerable description</string>
    <string name="maswe_0048_msg_compromised_build_pipeline_secure">Secure description</string>
    <string name="maswe_0048_vector_hidden_functionality_vuln">4. Hidden Functionality</string>
    <string name="maswe_0048_vector_hidden_functionality_secure">4. Secure: Feature Transparency</string>
    <string name="maswe_0048_msg_hidden_functionality_vuln">Vulnerable description</string>
    <string name="maswe_0048_msg_hidden_functionality_secure">Secure description</string>

    <!-- MASWE-0049 Vectors -->
    <string name="maswe_0049_vector_loading_from_writable_locations_vuln">1. Loading From Writable Locations</string>
    <string name="maswe_0049_vector_loading_from_writable_locations_secure">1. Secure: Loading from Read-Only</string>
    <string name="maswe_0049_msg_loading_from_writable_locations_vuln">Vulnerable description</string>
    <string name="maswe_0049_msg_loading_from_writable_locations_secure">Secure description</string>
    <string name="maswe_0049_vector_downloaded_code_without_verification_vuln">2. Downloaded Code Without Verification</string>
    <string name="maswe_0049_vector_downloaded_code_without_verification_secure">2. Secure: Code Integrity Verified</string>
    <string name="maswe_0049_msg_downloaded_code_without_verification_vuln">Vulnerable description</string>
    <string name="maswe_0049_msg_downloaded_code_without_verification_secure">Secure description</string>
    <string name="maswe_0049_vector_code_from_other_packages_vuln">3. Code From Other Packages</string>
    <string name="maswe_0049_vector_code_from_other_packages_secure">3. Secure: App Context Isolation</string>
    <string name="maswe_0049_msg_code_from_other_packages_vuln">Vulnerable description</string>
    <string name="maswe_0049_msg_code_from_other_packages_secure">Secure description</string>

    <!-- MASWE-0050 Vectors -->
    <string name="maswe_0050_vector_missing_validation_at_trust_boundaries_vuln">1. Missing Validation at Trust Boundaries</string>
    <string name="maswe_0050_vector_missing_validation_at_trust_boundaries_secure">1. Secure: Strict Input Validation</string>
    <string name="maswe_0050_msg_missing_validation_at_trust_boundaries_vuln">Vulnerable description</string>
    <string name="maswe_0050_msg_missing_validation_at_trust_boundaries_secure">Secure description</string>
    <string name="maswe_0050_vector_untrusted_data_in_queries_vuln">2. Untrusted Data in Queries</string>
    <string name="maswe_0050_vector_untrusted_data_in_queries_secure">2. Secure: Parameterized Queries</string>
    <string name="maswe_0050_msg_untrusted_data_in_queries_vuln">Vulnerable description</string>
    <string name="maswe_0050_msg_untrusted_data_in_queries_secure">Secure description</string>
    <string name="maswe_0050_vector_untrusted_paths_and_archives_vuln">3. Untrusted Paths and Archives</string>
    <string name="maswe_0050_vector_untrusted_paths_and_archives_secure">3. Secure: Path Canonicalization</string>
    <string name="maswe_0050_msg_untrusted_paths_and_archives_vuln">Vulnerable description</string>
    <string name="maswe_0050_msg_untrusted_paths_and_archives_secure">Secure description</string>
    <string name="maswe_0050_vector_insecure_parsing_vuln">4. Insecure Parsing</string>
    <string name="maswe_0050_vector_insecure_parsing_secure">4. Secure: Safe Parser Configuration</string>
    <string name="maswe_0050_msg_insecure_parsing_vuln">Vulnerable description</string>
    <string name="maswe_0050_msg_insecure_parsing_secure">Secure description</string>
    <string name="maswe_0050_vector_insecure_deserialization_vuln">5. Insecure Deserialization</string>
    <string name="maswe_0050_vector_insecure_deserialization_secure">5. Secure: Restricted Types Deserialization</string>
    <string name="maswe_0050_msg_insecure_deserialization_vuln">Vulnerable description</string>
    <string name="maswe_0050_msg_insecure_deserialization_secure">Secure description</string>
    <string name="maswe_0050_vector_weakly_validated_uri_handling_vuln">6. Weakly Validated URI Handling</string>
    <string name="maswe_0050_vector_weakly_validated_uri_handling_secure">6. Secure: Robust URI Validation</string>
    <string name="maswe_0050_msg_weakly_validated_uri_handling_vuln">Vulnerable description</string>
    <string name="maswe_0050_msg_weakly_validated_uri_handling_secure">Secure description</string>
    <string name="maswe_0050_vector_unsafe_presentation_of_untrusted_data_vuln">7. Unsafe Presentation of Untrusted Data</string>
    <string name="maswe_0050_vector_unsafe_presentation_of_untrusted_data_secure">7. Secure: Length and Format Constrained</string>
    <string name="maswe_0050_msg_unsafe_presentation_of_untrusted_data_vuln">Vulnerable description</string>
    <string name="maswe_0050_msg_unsafe_presentation_of_untrusted_data_secure">Secure description</string>
"""

with open("/Users/PROJECTS_ALL/Appfiliate/AndroidSecurityMasterclass/common/src/main/res/values/strings.xml", "r") as f:
    content = f.read()

# Insert before </resources>
content = content.replace("</resources>", STRINGS + "\n</resources>")

with open("/Users/PROJECTS_ALL/Appfiliate/AndroidSecurityMasterclass/common/src/main/res/values/strings.xml", "w") as f:
    f.write(content)
