package com.dicoding.picodiploma.loginwithanimation.data.postRequest

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val phone: String
)