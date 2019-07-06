package com.example.android_kotlin_retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.android_kotlin_retrofit.model.User
import com.example.android_kotlin_retrofit.model.Users
import com.example.android_kotlin_retrofit.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var app: Application? = null
    private var repository: UserRepository? = null

    init {
        app = application
        if (repository == null) {
            repository = UserRepository()
        }
    }

    // get user list live data
    fun getUsersListLiveData(): MutableLiveData<MutableList<Users>>? {
        return repository?.getUsersLiveData()
    }


    // get user live data
    fun getUserLiveData(userId: String): MutableLiveData<User>? {
        return repository?.getUserInfo(userId)
    }
}