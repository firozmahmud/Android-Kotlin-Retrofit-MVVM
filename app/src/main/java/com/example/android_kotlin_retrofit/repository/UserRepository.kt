package com.example.android_kotlin_retrofit.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.android_kotlin_retrofit.model.Users
import com.example.android_kotlin_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {

    private var usersLiveData: MutableLiveData<List<Users>>? = null
    private val TAG = "UserRepository"

    fun getUsersLiveData(): MutableLiveData<List<Users>> {
        if (usersLiveData == null) {
            usersLiveData = MutableLiveData()
        }

        ApiClient.apiService?.getUserList()
            ?.enqueue(object : Callback<List<Users>> {
                override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {

                    if (response.isSuccessful) {
                        usersLiveData?.setValue(response.body())
                    } else {
                        Log.e(TAG, "Response Error : " + response?.errorBody())
                    }
                }

                override fun onFailure(call: Call<List<Users>>, t: Throwable) {

                    Log.e(TAG, "Response Failure : " + t.message)
                }
            })

        return usersLiveData as MutableLiveData<List<Users>>
    }
}
