package com.example.android_kotlin_retrofit.listener

import com.example.android_kotlin_retrofit.model.User
import com.example.android_kotlin_retrofit.model.Users
import java.text.FieldPosition

interface ItemClick {
    fun itemClick(user: Users)
    fun itemLongClick(user: Users)
}
