package com.example.android_kotlin_retrofit.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_kotlin_retrofit.R
import com.example.android_kotlin_retrofit.listener.ItemClick
import com.example.android_kotlin_retrofit.model.Users

class UserAdapter(private val context: Context, private val users: MutableList<Users>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val TAG = "UserAdapter"
    private var itemClick: ItemClick? = null

    init {
        itemClick = context as ItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userPhoto?.let { Glide.with(context).load(users[position].avatarUrl).into(it) }

        holder.itemView.setOnClickListener {
            itemClick?.itemClick(users.get(position))
        }
        holder.itemView.setOnLongClickListener {
            itemClick?.itemLongClick(users.get(position))
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "UserList Size : " + users.size)
        return users.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var userPhoto: ImageView? = null

        init {
            userPhoto = itemView.findViewById(R.id.userPhoto)
        }

    }
}
