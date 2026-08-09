import re

STRINGS = """
    <!-- MASWE-0029 to MASWE-0040 Titles -->
    <string name="maswe_0029_id">MASWE-0029</string>
    <string name="maswe_0029_title">Insecure Deep Links</string>
    <string name="maswe_0030_id">MASWE-0030</string>
    <string name="maswe_0030_title">Improper Use of the Clipboard</string>
    <string name="maswe_0031_id">MASWE-0031</string>
    <string name="maswe_0031_title">Allowing Untrusted App Extensions</string>
    <string name="maswe_0032_id">MASWE-0032</string>
    <string name="maswe_0032_title">Insecure Intents</string>
    <string name="maswe_0033_id">MASWE-0033</string>
    <string name="maswe_0033_title">Sensitive Native Functionality Exposed in WebViews</string>
    <string name="maswe_0034_id">MASWE-0034</string>
    <string name="maswe_0034_title">WebViews Allow Access to Local Resources with Untrusted Content</string>
    <string name="maswe_0035_id">MASWE-0035</string>
    <string name="maswe_0035_title">WebViews Loading Untrusted Content</string>
    <string name="maswe_0036_id">MASWE-0036</string>
    <string name="maswe_0036_title">Unnecessary Exposure of Sensitive Data via the User Interface</string>
    <string name="maswe_0037_id">MASWE-0037</string>
    <string name="maswe_0037_title">Unnecessary Exposure of Sensitive Data via Notifications</string>
    <string name="maswe_0038_id">MASWE-0038</string>
    <string name="maswe_0038_title">Insufficient Protection of Sensitive Data from Screenshots or Screen Recordings</string>
    <string name="maswe_0039_id">MASWE-0039</string>
    <string name="maswe_0039_title">App Vulnerable to Overlay Attacks</string>
    <string name="maswe_0040_id">MASWE-0040</string>
    <string name="maswe_0040_title">Sensitive Data Leaked via Accessibility Services</string>

    <!-- MASWE-0029 Vectors -->
    <string name="maswe_0029_vector_unverified_custom_url_scheme_vuln">1. Unverified Custom URL Scheme</string>
    <string name="maswe_0029_vector_unverified_custom_url_scheme_secure">1. Secure: Safe Intent Handling</string>
    <string name="maswe_0029_msg_unverified_custom_url_scheme_vuln">Vulnerable description</string>
    <string name="maswe_0029_msg_unverified_custom_url_scheme_secure">Secure description</string>
    <string name="maswe_0029_vector_missing_domain_association_vuln">2. Missing Domain Association</string>
    <string name="maswe_0029_vector_missing_domain_association_secure">2. Secure: autoVerify Enabled</string>
    <string name="maswe_0029_msg_missing_domain_association_vuln">Vulnerable description</string>
    <string name="maswe_0029_msg_missing_domain_association_secure">Secure description</string>
    <string name="maswe_0029_vector_unvalidated_deep_link_input_vuln">3. Unvalidated Deep Link Input</string>
    <string name="maswe_0029_vector_unvalidated_deep_link_input_secure">3. Secure: Strict URL Validation</string>
    <string name="maswe_0029_msg_unvalidated_deep_link_input_vuln">Vulnerable description</string>
    <string name="maswe_0029_msg_unvalidated_deep_link_input_secure">Secure description</string>

    <!-- MASWE-0030 Vectors -->
    <string name="maswe_0030_vector_sensitive_data_copyable_vuln">1. Sensitive Data Copyable</string>
    <string name="maswe_0030_vector_sensitive_data_copyable_secure">1. Secure: Copy Disabled</string>
    <string name="maswe_0030_msg_sensitive_data_copyable_vuln">Vulnerable description</string>
    <string name="maswe_0030_msg_sensitive_data_copyable_secure">Secure description</string>
    <string name="maswe_0030_vector_clipboard_not_marked_sensitive_vuln">2. Clipboard Not Marked Sensitive</string>
    <string name="maswe_0030_vector_clipboard_not_marked_sensitive_secure">2. Secure: IS_SENSITIVE flag</string>
    <string name="maswe_0030_msg_clipboard_not_marked_sensitive_vuln">Vulnerable description</string>
    <string name="maswe_0030_msg_clipboard_not_marked_sensitive_secure">Secure description</string>
    <string name="maswe_0030_vector_universal_clipboard_not_restricted_vuln">3. Universal Clipboard Unrestricted</string>
    <string name="maswe_0030_vector_universal_clipboard_not_restricted_secure">3. Secure: Local Only</string>
    <string name="maswe_0030_msg_universal_clipboard_not_restricted_vuln">Vulnerable description</string>
    <string name="maswe_0030_msg_universal_clipboard_not_restricted_secure">Secure description</string>
    <string name="maswe_0030_vector_clipboard_not_cleared_vuln">4. Clipboard Not Cleared</string>
    <string name="maswe_0030_vector_clipboard_not_cleared_secure">4. Secure: Timed Clear</string>
    <string name="maswe_0030_msg_clipboard_not_cleared_vuln">Vulnerable description</string>
    <string name="maswe_0030_msg_clipboard_not_cleared_secure">Secure description</string>
    <string name="maswe_0030_vector_untrusted_clipboard_input_vuln">5. Untrusted Clipboard Input</string>
    <string name="maswe_0030_vector_untrusted_clipboard_input_secure">5. Secure: Input Sanitized</string>
    <string name="maswe_0030_msg_untrusted_clipboard_input_vuln">Vulnerable description</string>
    <string name="maswe_0030_msg_untrusted_clipboard_input_secure">Secure description</string>

    <!-- MASWE-0031 Vectors -->
    <string name="maswe_0031_vector_all_extension_points_allowed_vuln">1. All Extension Points Allowed</string>
    <string name="maswe_0031_vector_all_extension_points_allowed_secure">1. Secure: Extensions Restricted</string>
    <string name="maswe_0031_msg_all_extension_points_allowed_vuln">Vulnerable description</string>
    <string name="maswe_0031_msg_all_extension_points_allowed_secure">Secure description</string>
    <string name="maswe_0031_vector_third_party_keyboards_sensitive_input_vuln">2. 3rd-Party Keyboards in Sensitive Input</string>
    <string name="maswe_0031_vector_third_party_keyboards_sensitive_input_secure">2. Secure: Keyboards Blocked</string>
    <string name="maswe_0031_msg_third_party_keyboards_sensitive_input_vuln">Vulnerable description</string>
    <string name="maswe_0031_msg_third_party_keyboards_sensitive_input_secure">Secure description</string>
    <string name="maswe_0031_vector_sensitive_data_handed_to_extensions_vuln">3. Sensitive Data Handed Out</string>
    <string name="maswe_0031_vector_sensitive_data_handed_to_extensions_secure">3. Secure: Minimal Data Sharing</string>
    <string name="maswe_0031_msg_sensitive_data_handed_to_extensions_vuln">Vulnerable description</string>
    <string name="maswe_0031_msg_sensitive_data_handed_to_extensions_secure">Secure description</string>

    <!-- MASWE-0032 Vectors -->
    <string name="maswe_0032_vector_implicit_intents_internal_vuln">1. Implicit Intents Internal</string>
    <string name="maswe_0032_vector_implicit_intents_internal_secure">1. Secure: Explicit Intents Only</string>
    <string name="maswe_0032_msg_implicit_intents_internal_vuln">Vulnerable description</string>
    <string name="maswe_0032_msg_implicit_intents_internal_secure">Secure description</string>
    <string name="maswe_0032_vector_intent_redirection_vuln">2. Intent Redirection</string>
    <string name="maswe_0032_vector_intent_redirection_secure">2. Secure: Intent Validated</string>
    <string name="maswe_0032_msg_intent_redirection_vuln">Vulnerable description</string>
    <string name="maswe_0032_msg_intent_redirection_secure">Secure description</string>
    <string name="maswe_0032_vector_mutable_pending_intents_vuln">3. Mutable Pending Intents</string>
    <string name="maswe_0032_vector_mutable_pending_intents_secure">3. Secure: FLAG_IMMUTABLE</string>
    <string name="maswe_0032_msg_mutable_pending_intents_vuln">Vulnerable description</string>
    <string name="maswe_0032_msg_mutable_pending_intents_secure">Secure description</string>
    <string name="maswe_0032_vector_replayable_pending_intents_vuln">4. Replayable Pending Intents</string>
    <string name="maswe_0032_vector_replayable_pending_intents_secure">4. Secure: FLAG_ONE_SHOT</string>
    <string name="maswe_0032_msg_replayable_pending_intents_vuln">Vulnerable description</string>
    <string name="maswe_0032_msg_replayable_pending_intents_secure">Secure description</string>
    <string name="maswe_0032_vector_sticky_broadcasts_vuln">5. Sticky Broadcasts</string>
    <string name="maswe_0032_vector_sticky_broadcasts_secure">5. Secure: Standard Broadcasts</string>
    <string name="maswe_0032_msg_sticky_broadcasts_vuln">Vulnerable description</string>
    <string name="maswe_0032_msg_sticky_broadcasts_secure">Secure description</string>

    <!-- MASWE-0033 Vectors -->
    <string name="maswe_0033_vector_bridges_reachable_by_untrusted_vuln">1. Bridges Reachable</string>
    <string name="maswe_0033_vector_bridges_reachable_by_untrusted_secure">1. Secure: Scoped Bridges</string>
    <string name="maswe_0033_msg_bridges_reachable_by_untrusted_vuln">Vulnerable description</string>
    <string name="maswe_0033_msg_bridges_reachable_by_untrusted_secure">Secure description</string>
    <string name="maswe_0033_vector_unvalidated_bridge_messages_vuln">2. Unvalidated Bridge Messages</string>
    <string name="maswe_0033_vector_unvalidated_bridge_messages_secure">2. Secure: Input Sanitized</string>
    <string name="maswe_0033_msg_unvalidated_bridge_messages_vuln">Vulnerable description</string>
    <string name="maswe_0033_msg_unvalidated_bridge_messages_secure">Secure description</string>
    <string name="maswe_0033_vector_globally_exposed_bridges_vuln">3. Globally Exposed Bridges</string>
    <string name="maswe_0033_vector_globally_exposed_bridges_secure">3. Secure: Explicit Methods</string>
    <string name="maswe_0033_msg_globally_exposed_bridges_vuln">Vulnerable description</string>
    <string name="maswe_0033_msg_globally_exposed_bridges_secure">Secure description</string>
    <string name="maswe_0033_vector_app_owned_scripts_page_world_vuln">4. App Scripts in Page World</string>
    <string name="maswe_0033_vector_app_owned_scripts_page_world_secure">4. Secure: Isolated Context</string>
    <string name="maswe_0033_msg_app_owned_scripts_page_world_vuln">Vulnerable description</string>
    <string name="maswe_0033_msg_app_owned_scripts_page_world_secure">Secure description</string>
    <string name="maswe_0033_vector_sensitive_data_in_bridge_replies_vuln">5. Sensitive Data in Replies</string>
    <string name="maswe_0033_vector_sensitive_data_in_bridge_replies_secure">5. Secure: Masked Replies</string>
    <string name="maswe_0033_msg_sensitive_data_in_bridge_replies_vuln">Vulnerable description</string>
    <string name="maswe_0033_msg_sensitive_data_in_bridge_replies_secure">Secure description</string>
    <string name="maswe_0033_vector_over_exposed_bridges_vuln">6. Over Exposed Bridges</string>
    <string name="maswe_0033_vector_over_exposed_bridges_secure">6. Secure: Least Privilege</string>
    <string name="maswe_0033_msg_over_exposed_bridges_vuln">Vulnerable description</string>
    <string name="maswe_0033_msg_over_exposed_bridges_secure">Secure description</string>

    <!-- MASWE-0034 Vectors -->
    <string name="maswe_0034_vector_file_access_enabled_vuln">1. File Access Enabled</string>
    <string name="maswe_0034_vector_file_access_enabled_secure">1. Secure: File Access Disabled</string>
    <string name="maswe_0034_msg_file_access_enabled_vuln">Vulnerable description</string>
    <string name="maswe_0034_msg_file_access_enabled_secure">Secure description</string>
    <string name="maswe_0034_vector_universal_access_from_file_urls_vuln">2. Universal File Access</string>
    <string name="maswe_0034_vector_universal_access_from_file_urls_secure">2. Secure: Universal Access False</string>
    <string name="maswe_0034_msg_universal_access_from_file_urls_vuln">Vulnerable description</string>
    <string name="maswe_0034_msg_universal_access_from_file_urls_secure">Secure description</string>
    <string name="maswe_0034_vector_insecure_custom_resource_loading_vuln">3. Insecure Resource Loading</string>
    <string name="maswe_0034_vector_insecure_custom_resource_loading_secure">3. Secure: Validated Assets</string>
    <string name="maswe_0034_msg_insecure_custom_resource_loading_vuln">Vulnerable description</string>
    <string name="maswe_0034_msg_insecure_custom_resource_loading_secure">Secure description</string>
    <string name="maswe_0034_vector_overly_broad_file_read_grants_vuln">4. Broad File Read</string>
    <string name="maswe_0034_vector_overly_broad_file_read_grants_secure">4. Secure: Scoped Read</string>
    <string name="maswe_0034_msg_overly_broad_file_read_grants_vuln">Vulnerable description</string>
    <string name="maswe_0034_msg_overly_broad_file_read_grants_secure">Secure description</string>

    <!-- MASWE-0035 Vectors -->
    <string name="maswe_0035_vector_unrestricted_navigation_vuln">1. Unrestricted Navigation</string>
    <string name="maswe_0035_vector_unrestricted_navigation_secure">1. Secure: Domain Allowlist</string>
    <string name="maswe_0035_msg_unrestricted_navigation_vuln">Vulnerable description</string>
    <string name="maswe_0035_msg_unrestricted_navigation_secure">Secure description</string>
    <string name="maswe_0035_vector_untrusted_urls_from_external_vuln">2. Untrusted External URLs</string>
    <string name="maswe_0035_vector_untrusted_urls_from_external_secure">2. Secure: Validated URLs</string>
    <string name="maswe_0035_msg_untrusted_urls_from_external_vuln">Vulnerable description</string>
    <string name="maswe_0035_msg_untrusted_urls_from_external_secure">Secure description</string>
    <string name="maswe_0035_vector_untrusted_script_inclusion_vuln">3. Untrusted Scripts</string>
    <string name="maswe_0035_vector_untrusted_script_inclusion_secure">3. Secure: SRI Checked</string>
    <string name="maswe_0035_msg_untrusted_script_inclusion_vuln">Vulnerable description</string>
    <string name="maswe_0035_msg_untrusted_script_inclusion_secure">Secure description</string>
    <string name="maswe_0035_vector_safe_browsing_disabled_vuln">4. Safe Browsing Disabled</string>
    <string name="maswe_0035_vector_safe_browsing_disabled_secure">4. Secure: Safe Browsing On</string>
    <string name="maswe_0035_msg_safe_browsing_disabled_vuln">Vulnerable description</string>
    <string name="maswe_0035_msg_safe_browsing_disabled_secure">Secure description</string>
    <string name="maswe_0035_vector_deprecated_webview_components_vuln">5. Deprecated WebViews</string>
    <string name="maswe_0035_vector_deprecated_webview_components_secure">5. Secure: Modern WebViews</string>
    <string name="maswe_0035_msg_deprecated_webview_components_vuln">Vulnerable description</string>
    <string name="maswe_0035_msg_deprecated_webview_components_secure">Secure description</string>

    <!-- MASWE-0036 Vectors -->
    <string name="maswe_0036_vector_non_secure_text_entry_vuln">1. Non-Secure Text Entry</string>
    <string name="maswe_0036_vector_non_secure_text_entry_secure">1. Secure: Password Type</string>
    <string name="maswe_0036_msg_non_secure_text_entry_vuln">Vulnerable description</string>
    <string name="maswe_0036_msg_non_secure_text_entry_secure">Secure description</string>
    <string name="maswe_0036_vector_unmasked_sensitive_values_vuln">2. Unmasked Sensitive Data</string>
    <string name="maswe_0036_vector_unmasked_sensitive_values_secure">2. Secure: Masked Data</string>
    <string name="maswe_0036_msg_unmasked_sensitive_values_vuln">Vulnerable description</string>
    <string name="maswe_0036_msg_unmasked_sensitive_values_secure">Secure description</string>

    <!-- MASWE-0037 Vectors -->
    <string name="maswe_0037_vector_sensitive_content_in_notifications_vuln">1. Sensitive Notifications</string>
    <string name="maswe_0037_vector_sensitive_content_in_notifications_secure">1. Secure: Generic Message</string>
    <string name="maswe_0037_msg_sensitive_content_in_notifications_vuln">Vulnerable description</string>
    <string name="maswe_0037_msg_sensitive_content_in_notifications_secure">Secure description</string>
    <string name="maswe_0037_vector_no_lock_screen_redaction_vuln">2. No Lock Screen Redaction</string>
    <string name="maswe_0037_vector_no_lock_screen_redaction_secure">2. Secure: VISIBILITY_PRIVATE</string>
    <string name="maswe_0037_msg_no_lock_screen_redaction_vuln">Vulnerable description</string>
    <string name="maswe_0037_msg_no_lock_screen_redaction_secure">Secure description</string>

    <!-- MASWE-0038 Vectors -->
    <string name="maswe_0038_vector_missing_platform_screenshot_protection_vuln">1. Missing FLAG_SECURE</string>
    <string name="maswe_0038_vector_missing_platform_screenshot_protection_secure">1. Secure: FLAG_SECURE Set</string>
    <string name="maswe_0038_msg_missing_platform_screenshot_protection_vuln">Vulnerable description</string>
    <string name="maswe_0038_msg_missing_platform_screenshot_protection_secure">Secure description</string>
    <string name="maswe_0038_vector_missing_capture_state_redaction_vuln">2. Missing Capture Redaction</string>
    <string name="maswe_0038_vector_missing_capture_state_redaction_secure">2. Secure: Capture Detected</string>
    <string name="maswe_0038_msg_missing_capture_state_redaction_vuln">Vulnerable description</string>
    <string name="maswe_0038_msg_missing_capture_state_redaction_secure">Secure description</string>
    <string name="maswe_0038_vector_excessive_on_screen_disclosure_vuln">3. Excessive Disclosure</string>
    <string name="maswe_0038_vector_excessive_on_screen_disclosure_secure">3. Secure: Minimal Info</string>
    <string name="maswe_0038_msg_excessive_on_screen_disclosure_vuln">Vulnerable description</string>
    <string name="maswe_0038_msg_excessive_on_screen_disclosure_secure">Secure description</string>

    <!-- MASWE-0039 Vectors -->
    <string name="maswe_0039_vector_touch_filtering_not_enabled_vuln">1. Touch Filtering Not Enabled</string>
    <string name="maswe_0039_vector_touch_filtering_not_enabled_secure">1. Secure: Touch Filtering On</string>
    <string name="maswe_0039_msg_touch_filtering_not_enabled_vuln">Vulnerable description</string>
    <string name="maswe_0039_msg_touch_filtering_not_enabled_secure">Secure description</string>
    <string name="maswe_0039_vector_external_overlays_not_hidden_vuln">2. External Overlays Shown</string>
    <string name="maswe_0039_vector_external_overlays_not_hidden_secure">2. Secure: Overlays Hidden</string>
    <string name="maswe_0039_msg_external_overlays_not_hidden_vuln">Vulnerable description</string>
    <string name="maswe_0039_msg_external_overlays_not_hidden_secure">Secure description</string>
    <string name="maswe_0039_vector_sensitive_screens_not_protected_vuln">3. Sensitive Screens Exposed</string>
    <string name="maswe_0039_vector_sensitive_screens_not_protected_secure">3. Secure: Protected Views</string>
    <string name="maswe_0039_msg_sensitive_screens_not_protected_vuln">Vulnerable description</string>
    <string name="maswe_0039_msg_sensitive_screens_not_protected_secure">Secure description</string>

    <!-- MASWE-0040 Vectors -->
    <string name="maswe_0040_vector_secrets_in_accessibility_metadata_vuln">1. Secrets in A11y Metadata</string>
    <string name="maswe_0040_vector_secrets_in_accessibility_metadata_secure">1. Secure: Clean Metadata</string>
    <string name="maswe_0040_msg_secrets_in_accessibility_metadata_vuln">Vulnerable description</string>
    <string name="maswe_0040_msg_secrets_in_accessibility_metadata_secure">Secure description</string>
    <string name="maswe_0040_vector_sensitive_fields_not_secure_input_vuln">2. Non-Secure Fields Read</string>
    <string name="maswe_0040_vector_sensitive_fields_not_secure_input_secure">2. Secure: Password Input Type</string>
    <string name="maswe_0040_msg_sensitive_fields_not_secure_input_vuln">Vulnerable description</string>
    <string name="maswe_0040_msg_sensitive_fields_not_secure_input_secure">Secure description</string>
    <string name="maswe_0040_vector_high_risk_flows_automatable_vuln">3. Automatable Risk Flows</string>
    <string name="maswe_0040_vector_high_risk_flows_automatable_secure">3. Secure: Biometric Required</string>
    <string name="maswe_0040_msg_high_risk_flows_automatable_vuln">Vulnerable description</string>
    <string name="maswe_0040_msg_high_risk_flows_automatable_secure">Secure description</string>
    <string name="maswe_0040_vector_system_keyboards_exposing_input_vuln">4. System Keyboard Exposure</string>
    <string name="maswe_0040_vector_system_keyboards_exposing_input_secure">4. Secure: Secure Keypad</string>
    <string name="maswe_0040_msg_system_keyboards_exposing_input_vuln">Vulnerable description</string>
    <string name="maswe_0040_msg_system_keyboards_exposing_input_secure">Secure description</string>
"""

with open("/Users/PROJECTS_ALL/Appfiliate/AndroidSecurityMasterclass/common/src/main/res/values/strings.xml", "r") as f:
    content = f.read()

# Insert before </resources>
content = content.replace("</resources>", STRINGS + "\n</resources>")

with open("/Users/PROJECTS_ALL/Appfiliate/AndroidSecurityMasterclass/common/src/main/res/values/strings.xml", "w") as f:
    f.write(content)
