package com.example.android_kotlin_retrofit.listener

import android.view.View
import com.example.android_kotlin_retrofit.model.Users

interface ItemClick {
    fun itemClick(user: Users)
    fun itemLongClick(user: Users, itemView: View)
}
