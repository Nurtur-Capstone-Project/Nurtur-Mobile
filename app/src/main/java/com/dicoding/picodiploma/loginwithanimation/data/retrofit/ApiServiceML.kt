package com.dicoding.picodiploma.loginwithanimation.data.retrofit

import com.dicoding.picodiploma.loginwithanimation.data.response.MachineLearningResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiServiceML {
    @Multipart
    @POST("prediction")
    suspend fun postMoodDetection(
        @Part image: MultipartBody.Part,
    ): MachineLearningResponse
}