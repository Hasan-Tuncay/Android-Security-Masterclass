package com.hasantuncay.mobsec.core.auditor

import com.hasantuncay.mobsec.core.auditor.models.AuditorTree
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class AuditorTreeTest {

    @Test
    fun `test valid json deserializes into AuditorTree successfully`() {
        // Arrange
        val jsonString = """
            {
              "id": "masvs_storage",
              "title": "Storage Security",
              "start_node": "q1",
              "nodes": {
                "q1": {
                  "type": "question",
                  "text": "Do you store data?",
                  "options": [
                    { "text": "No", "next": "pass_result" },
                    { "text": "Yes", "next": "q2" }
                  ]
                },
                "pass_result": {
                  "type": "result",
                  "status": "PASS"
                }
              }
            }
        """.trimIndent()

        // Act
        val tree = Json.decodeFromString<AuditorTree>(jsonString)

        // Assert
        assertEquals("masvs_storage", tree.id)
        assertEquals("Storage Security", tree.title)
        assertEquals("q1", tree.startNode)
        assertEquals(2, tree.nodes.size)
        assertEquals("question", tree.nodes["q1"]?.type)
        assertEquals("result", tree.nodes["pass_result"]?.type)
    }
}
