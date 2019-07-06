package com.example.android_kotlin_retrofit.network

import com.example.android_kotlin_retrofit.model.User
import com.example.android_kotlin_retrofit.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users")
    fun getUserList(): Call<MutableList<Users>>

    @GET("users/{id}")
    fun getUser(@Path("id") path: String): Call<User>
}
