package com.example.android_kotlin_retrofit.model.remote

import androidx.lifecycle.MutableLiveData
import com.example.android_kotlin_retrofit.model.pojo_class.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    fun getUserList(@Query("q") filter: String): Call<MutableLiveData<List<Users>>>
}
