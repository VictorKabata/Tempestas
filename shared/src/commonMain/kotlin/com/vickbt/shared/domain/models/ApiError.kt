package com.vickbt.shared.domain.models

data class ApiError(
    val code: String,
    val description: String
) : Exception()
