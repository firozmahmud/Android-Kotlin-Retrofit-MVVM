package com.example.android_kotlin_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.android_kotlin_retrofit.R
import com.example.android_kotlin_retrofit.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {

    private var userId: String = ""
    private var viewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        initObjects()
        loadData()
    }

    private fun initObjects() {
        userId = intent.getStringExtra(getString(R.string.user_id))
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    private fun loadData() {
        viewModel?.getUserLiveData(userId)?.observe(this, Observer {
            Glide.with(this).load(it.avatarUrl).into(userPhotoIv)
            userNameTv.text = it.name
            publicRepoTv.text = "Public Repo: " + it.publicRepos
            followerTv.text = "Follower: " + it.followers
            followingTv.text = "Following: " + it.following
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
