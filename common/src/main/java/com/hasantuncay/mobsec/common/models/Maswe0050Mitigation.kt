package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0050Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MISSING_VALIDATION_AT_TRUST_BOUNDARIES(
        titleSecureRes = R.string.maswe_0050_vector_missing_validation_at_trust_boundaries_secure,
        msgSecureRes = R.string.maswe_0050_msg_missing_validation_at_trust_boundaries_secure,
        icon = Icons.Default.Rule
    ),
    UNTRUSTED_DATA_IN_QUERIES(
        titleSecureRes = R.string.maswe_0050_vector_untrusted_data_in_queries_secure,
        msgSecureRes = R.string.maswe_0050_msg_untrusted_data_in_queries_secure,
        icon = Icons.Default.Storage
    ),
    UNTRUSTED_PATHS_AND_ARCHIVES(
        titleSecureRes = R.string.maswe_0050_vector_untrusted_paths_and_archives_secure,
        msgSecureRes = R.string.maswe_0050_msg_untrusted_paths_and_archives_secure,
        icon = Icons.Default.Folder
    ),
    INSECURE_PARSING(
        titleSecureRes = R.string.maswe_0050_vector_insecure_parsing_secure,
        msgSecureRes = R.string.maswe_0050_msg_insecure_parsing_secure,
        icon = Icons.Default.Code
    ),
    INSECURE_DESERIALIZATION(
        titleSecureRes = R.string.maswe_0050_vector_insecure_deserialization_secure,
        msgSecureRes = R.string.maswe_0050_msg_insecure_deserialization_secure,
        icon = Icons.Default.DataArray
    ),
    WEAKLY_VALIDATED_URI_HANDLING(
        titleSecureRes = R.string.maswe_0050_vector_weakly_validated_uri_handling_secure,
        msgSecureRes = R.string.maswe_0050_msg_weakly_validated_uri_handling_secure,
        icon = Icons.Default.Link
    ),
    UNSAFE_PRESENTATION_OF_UNTRUSTED_DATA(
        titleSecureRes = R.string.maswe_0050_vector_unsafe_presentation_of_untrusted_data_secure,
        msgSecureRes = R.string.maswe_0050_msg_unsafe_presentation_of_untrusted_data_secure,
        icon = Icons.Default.Preview
    );

    override val masweId = "MASWE-0050"
    override val screenTitleSecureRes = R.string.maswe_0050_secure_title
    override val screenDescSecureRes = R.string.maswe_0050_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0050_secure_vectors_title
}
