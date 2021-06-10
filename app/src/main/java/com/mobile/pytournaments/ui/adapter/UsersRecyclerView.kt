 package com.mobile.pytournaments.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FriendlistBinding
import com.mobile.pytournaments.databinding.LinhaBinding
import com.mobile.pytournaments.domain.User
import com.mobile.pytournaments.domain.UserCadastraApi
import com.mobile.pytournaments.domain.UserModelo

class UsersRecyclerView(
    //private val userList: List<User>
    private val users: List<UserCadastraApi>
): RecyclerView.Adapter<UsersHolder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : UsersHolder {
        val template = LayoutInflater.from(parent.context).inflate(R.layout.friendlist, parent, false)
        return UsersHolder(template)
    }

    override fun onBindViewHolder(holder: UsersHolder, position: Int) {
        val usuario = users[position]
        holder.biding.userData = usuario
        holder.biding.executePendingBindings()
    }

    override fun getItemCount() = users.size

}

class UsersHolder(v : View): RecyclerView.ViewHolder(v) {
        val biding: FriendlistBinding = FriendlistBinding.bind(v)

}