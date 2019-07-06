package com.example.android_kotlin_retrofit.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android_kotlin_retrofit.R
import com.example.android_kotlin_retrofit.adapter.UserAdapter
import com.example.android_kotlin_retrofit.common.toast
import com.example.android_kotlin_retrofit.listener.ItemClick
import com.example.android_kotlin_retrofit.model.Users
import com.example.android_kotlin_retrofit.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity(), ItemClick {

    private var adapter: UserAdapter? = null
    private var viewmodel: UserViewModel? = null
    private var users: MutableList<Users>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initObjects()
        loadUser()
    }

    private fun initViews() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        backBtn.visibility = View.GONE
    }

    private fun initObjects() {
        viewmodel = ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    private fun loadUser() {
        viewmodel?.getUsersListLiveData()?.observe(this, Observer {
            recyclerView.adapter = UserAdapter(this, it)
        })
    }

    override fun itemClick(user: Users) {
        toast("User clicked")
        intent = Intent(this, UserDetailsActivity::class.java)
        intent.putExtra(getString(R.string.user_id), user.login)
        startActivity(intent)
    }

    override fun itemLongClick(user: Users, itemView: View) {
        toast("User long clicked")
        deleteBtn.visibility = View.VISIBLE
        toolbar.setBackgroundColor(resources.getColor(R.color.delete_toolbar))
        itemView.alpha = 0.5f

        deleteBtn.setOnClickListener {
            toast("Deleted")
            deleteBtn.visibility = View.GONE
            toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            itemView.alpha = 1f
        }
    }

    override fun onBackPressed() {
        // do nothing
    }
}