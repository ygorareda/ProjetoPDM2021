package com.mobile.pytournaments.domain

data class Result (
    val success: Boolean,
    val message: String,
    val e: Throwable?
    )