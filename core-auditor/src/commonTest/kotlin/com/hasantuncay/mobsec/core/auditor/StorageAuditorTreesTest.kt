package com.hasantuncay.mobsec.core.auditor

import com.hasantuncay.mobsec.core.auditor.data.StorageAuditorTrees
import com.hasantuncay.mobsec.core.auditor.validator.AuditorTreeValidator
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class StorageAuditorTreesTest {

    @Test
    fun test_all_storage_trees_are_valid_dags() {
        val trees = StorageAuditorTrees.allStorageTrees
        assertEquals(6, trees.size, "MASVS-STORAGE için 6 adet ağaç tanımlı olmalı")

        for (tree in trees) {
            val result = AuditorTreeValidator.validate(tree)
            assertTrue(
                result.isValid,
                "Ağaç ${tree.id} geçerli bir DAG olmalı. Tespit edilen hatalar: ${result.errors}"
            )
            assertTrue(result.errors.isEmpty(), "Hata listesi boş olmalı")
        }
    }

    @Test
    fun test_get_tree_by_id_resolution() {
        for (i in 1..6) {
            val id = "maswe-000$i"
            val tree = StorageAuditorTrees.getTree(id)
            assertNotNull(tree, "Ağaç $id bulunabilmeli")
            assertEquals(id, tree.id)
        }
    }
}
