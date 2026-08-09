package com.hasantuncay.mobsec.common.models.code

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0050Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MISSING_VALIDATION_AT_TRUST_BOUNDARIES(
        titleRes = R.string.maswe_0050_vector_missing_validation_at_trust_boundaries_secure,
        msgRes = R.string.maswe_0050_msg_missing_validation_at_trust_boundaries_secure,
        icon = Icons.Default.Rule
    ),
    UNTRUSTED_DATA_IN_QUERIES(
        titleRes = R.string.maswe_0050_vector_untrusted_data_in_queries_secure,
        msgRes = R.string.maswe_0050_msg_untrusted_data_in_queries_secure,
        icon = Icons.Default.Storage
    ),
    UNTRUSTED_PATHS_AND_ARCHIVES(
        titleRes = R.string.maswe_0050_vector_untrusted_paths_and_archives_secure,
        msgRes = R.string.maswe_0050_msg_untrusted_paths_and_archives_secure,
        icon = Icons.Default.Folder
    ),
    INSECURE_PARSING(
        titleRes = R.string.maswe_0050_vector_insecure_parsing_secure,
        msgRes = R.string.maswe_0050_msg_insecure_parsing_secure,
        icon = Icons.Default.Code
    ),
    INSECURE_DESERIALIZATION(
        titleRes = R.string.maswe_0050_vector_insecure_deserialization_secure,
        msgRes = R.string.maswe_0050_msg_insecure_deserialization_secure,
        icon = Icons.Default.DataArray
    ),
    WEAKLY_VALIDATED_URI_HANDLING(
        titleRes = R.string.maswe_0050_vector_weakly_validated_uri_handling_secure,
        msgRes = R.string.maswe_0050_msg_weakly_validated_uri_handling_secure,
        icon = Icons.Default.Link
    ),
    UNSAFE_PRESENTATION_OF_UNTRUSTED_DATA(
        titleRes = R.string.maswe_0050_vector_unsafe_presentation_of_untrusted_data_secure,
        msgRes = R.string.maswe_0050_msg_unsafe_presentation_of_untrusted_data_secure,
        icon = Icons.Default.Preview
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0050",
            titleRes = R.string.maswe_0050_secure_title,
            descRes = R.string.maswe_0050_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0050_secure_vectors_title
        )
    }
}
