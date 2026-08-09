package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0050Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MISSING_VALIDATION_AT_TRUST_BOUNDARIES(
        titleVulnRes = R.string.maswe_0050_vector_missing_validation_at_trust_boundaries_vuln,
        msgVulnRes = R.string.maswe_0050_msg_missing_validation_at_trust_boundaries_vuln,
        icon = Icons.Default.Rule
    ),
    UNTRUSTED_DATA_IN_QUERIES(
        titleVulnRes = R.string.maswe_0050_vector_untrusted_data_in_queries_vuln,
        msgVulnRes = R.string.maswe_0050_msg_untrusted_data_in_queries_vuln,
        icon = Icons.Default.Storage
    ),
    UNTRUSTED_PATHS_AND_ARCHIVES(
        titleVulnRes = R.string.maswe_0050_vector_untrusted_paths_and_archives_vuln,
        msgVulnRes = R.string.maswe_0050_msg_untrusted_paths_and_archives_vuln,
        icon = Icons.Default.Folder
    ),
    INSECURE_PARSING(
        titleVulnRes = R.string.maswe_0050_vector_insecure_parsing_vuln,
        msgVulnRes = R.string.maswe_0050_msg_insecure_parsing_vuln,
        icon = Icons.Default.Code
    ),
    INSECURE_DESERIALIZATION(
        titleVulnRes = R.string.maswe_0050_vector_insecure_deserialization_vuln,
        msgVulnRes = R.string.maswe_0050_msg_insecure_deserialization_vuln,
        icon = Icons.Default.DataArray
    ),
    WEAKLY_VALIDATED_URI_HANDLING(
        titleVulnRes = R.string.maswe_0050_vector_weakly_validated_uri_handling_vuln,
        msgVulnRes = R.string.maswe_0050_msg_weakly_validated_uri_handling_vuln,
        icon = Icons.Default.Link
    ),
    UNSAFE_PRESENTATION_OF_UNTRUSTED_DATA(
        titleVulnRes = R.string.maswe_0050_vector_unsafe_presentation_of_untrusted_data_vuln,
        msgVulnRes = R.string.maswe_0050_msg_unsafe_presentation_of_untrusted_data_vuln,
        icon = Icons.Default.Preview
    );

    override val masweId = "MASWE-0050"
    override val screenTitleVulnRes = R.string.maswe_0050_vuln_title
    override val screenDescVulnRes = R.string.maswe_0050_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0050_vuln_vectors_title
}
