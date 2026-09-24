package com.hasantuncay.mobsec.core.auditor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuditorTree(
    val id: String,
    val title: String,
    @SerialName("start_node")
    val startNode: String,
    val nodes: Map<String, AuditorNode>
)

@Serializable
sealed class AuditorNode {
    abstract val type: String
}

@Serializable
@SerialName("question")
data class QuestionNode(
    override val type: String = "question",
    val text: String,
    val options: List<Option> = emptyList()
) : AuditorNode()

@Serializable
data class Option(
    val text: String,
    val next: String
)

@Serializable
@SerialName("result")
data class ResultNode(
    override val type: String = "result",
    val status: String
) : AuditorNode()
