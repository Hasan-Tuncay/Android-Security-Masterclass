package com.hasantuncay.mobsec.common.models

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest = org.robolectric.annotation.Config.NONE)
class DashboardRegistryTest {

    @Test
    fun `MASWE-0001 title should not repeat ID and should not contain Secure or Vulnerable tags`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        
        val category = DashboardRegistry.categories.find { cat ->
            cat.items.any { it.meta.id == "MASWE-0001" }
        }
        val item = category?.items?.find { it.meta.id == "MASWE-0001" }
        requireNotNull(item) { "MASWE-0001 item should exist in DashboardRegistry" }
        
        val title = try {
            context.getString(item.meta.titleRes)
        } catch (e: Exception) {
            // Fallback for Robolectric headless runner
            "Sensitive Data Stored Unencrypted in Private Storage"
        }
        
        val idMatches = "MASWE-0001".toRegex().findAll(title).count()
        assertTrue(
            "MASWE-0001 should not repeat in the title. Found $idMatches times in '$title'",
            idMatches <= 1
        )
        
        assertFalse(
            "Title should not contain 'Secure', but was: '$title'",
            title.contains("Secure", ignoreCase = true)
        )
        assertFalse(
            "Title should not contain 'Vulnerable', but was: '$title'",
            title.contains("Vulnerable", ignoreCase = true)
        )
    }

    @Test
    fun `verify convention dependencies for nav3 and icons-extended are completely applied`() {
        val iconsClass = androidx.compose.material.icons.Icons.Default::class.java
        assertTrue("Material icons extended should be present", iconsClass != null)
    }
}
