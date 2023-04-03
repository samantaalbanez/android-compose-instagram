package com.android.compose_instagram.login.data.network

import com.android.compose_instagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {

    @GET("/v3/ba019aa7-b83e-45de-b6ed-b1fd2f0e18c6")
    suspend fun doLogin(): Response<LoginResponse>
}
