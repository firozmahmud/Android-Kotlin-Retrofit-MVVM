package com.example.android_kotlin_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android_kotlin_retrofit.R
import com.example.android_kotlin_retrofit.adapter.UserAdapter
import com.example.android_kotlin_retrofit.common.toast
import com.example.android_kotlin_retrofit.listener.ItemClick
import com.example.android_kotlin_retrofit.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClick {
    private var viewmodel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initObjects()
        loadUser()
    }

    private fun initViews() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    private fun initObjects() {
        viewmodel = ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    private fun loadUser() {
        viewmodel?.getUserLiveData()?.observe(this, Observer {
            recyclerView.adapter = UserAdapter(this, it)
        })
    }

    override fun itemClick(position: Int) {
        toast("User clicked")
    }

    override fun itemLongClick(position: Int) {
        toast("User long clicked")
    }
}
