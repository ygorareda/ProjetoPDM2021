package com.mobile.pytournaments.domain

data class LoginResult (
    val success: Boolean,
    val message: String,
    val e: Throwable?
    ){

}