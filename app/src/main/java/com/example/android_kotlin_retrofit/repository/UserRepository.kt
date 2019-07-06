package com.example.android_kotlin_retrofit.repository

import android.app.Application
import android.util.Log
import android.util.StatsLog
import androidx.lifecycle.MutableLiveData
import com.example.android_kotlin_retrofit.model.User
import com.example.android_kotlin_retrofit.model.Users
import com.example.android_kotlin_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {

    private var usersLiveData: MutableLiveData<MutableList<Users>>? = null
    private var user: MutableLiveData<User>? = null
    private val TAG = "UserRepository"

    // function for get list of user
    fun getUsersLiveData(): MutableLiveData<MutableList<Users>> {
        if (usersLiveData == null) {
            usersLiveData = MutableLiveData()
        }

        ApiClient.apiService?.getUserList()
            ?.enqueue(object : Callback<MutableList<Users>> {
                override fun onResponse(call: Call<MutableList<Users>>, response: Response<MutableList<Users>>) {

                    if (response.isSuccessful) {
                        usersLiveData?.setValue(response.body())
                    } else {
                        Log.e(TAG, "Response Error : " + response.errorBody())
                    }
                }

                override fun onFailure(call: Call<MutableList<Users>>, t: Throwable) {

                    Log.e(TAG, "Response Failure : " + t.message)
                }
            })

        return usersLiveData as MutableLiveData<MutableList<Users>>
    }


    // function for get user information
    fun getUserInfo(userId: String): MutableLiveData<User> {
        if (user == null) {
            user = MutableLiveData()
        }

        ApiClient.apiService?.getUser(userId)
            ?.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        user?.value = response.body()
                    } else {
                        Log.e(TAG, "User Response : " + response.errorBody())
                    }

                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.e(TAG, "User Failure : " + t.message)
                }
            })

        return user as MutableLiveData<User>
    }
}
