package com.dicoding.picodiploma.loginwithanimation.data.retrofit

import com.dicoding.picodiploma.loginwithanimation.data.postRequest.ChangePasswordRequest
import com.dicoding.picodiploma.loginwithanimation.data.postRequest.LoginRequest
import com.dicoding.picodiploma.loginwithanimation.data.postRequest.RegisterRequest
import com.dicoding.picodiploma.loginwithanimation.data.response.ChangePasswordResponse
import com.dicoding.picodiploma.loginwithanimation.data.response.CurrentResponse
import com.dicoding.picodiploma.loginwithanimation.data.response.LoginResponse
import com.dicoding.picodiploma.loginwithanimation.data.response.LogoutResponse
import com.dicoding.picodiploma.loginwithanimation.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("user/register")
    fun postRegister(
        @Body requestBody: RegisterRequest
    ): Call<RegisterResponse>

    @POST("user/login")
    fun postLogin(
        @Body requestBody: LoginRequest
    ): Call<LoginResponse>

    @PATCH("user/update-password/{userId}")
    fun postChangePassword(
        @Body requestBody: ChangePasswordRequest,
        @Path("userId") userId: String,
    ): Call<ChangePasswordResponse>

    @GET("user/current/{token}")
    fun getCurrent(
        @Path("token") token: String
    ): Call<CurrentResponse>

    @DELETE("user/logout/{userId}/{token}")
    fun deleteLogout(
        @Path("userId") userId: String,
        @Path("token") token: String
    ): Call<LogoutResponse>
}