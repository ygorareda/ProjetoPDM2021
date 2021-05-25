package com.mobile.pytournaments.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.domain.User

class UsersRecyclerView(
    private val userList: List<User>
): RecyclerView.Adapter<UsersHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UsersHolder(
        LayoutInflater
        .from(parent.context).inflate(null , parent, false)
    )

    override fun onBindViewHolder(holder: UsersHolder, position: Int) {

    }

    override fun getItemCount() = userList.size

}

class UsersHolder(v : View): RecyclerView.ViewHolder(v) {
//        val binding = fazer o fragment userlist
}