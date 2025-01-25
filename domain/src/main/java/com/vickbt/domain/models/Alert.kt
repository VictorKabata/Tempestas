package com.vickbt.domain.models

data class Alert(
    val senderName: String?,
    val event: String?,
    val start: Long?,
    val end: Long?,
    val description: String?,
    val tags: List<String>?
)