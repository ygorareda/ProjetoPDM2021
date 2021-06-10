package com.mobile.pytournaments.ui.fragment.main.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentListFriendsBinding
import com.mobile.pytournaments.databinding.FragmentMainTournamentsBinding
import com.mobile.pytournaments.databinding.FriendlistBinding
import com.mobile.pytournaments.ui.adapter.Horizontal_RecyclerView
import com.mobile.pytournaments.ui.adapter.UsersRecyclerView
import com.mobile.pytournaments.viewmodel.LoggedUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFriendsFragment : Fragment() {

    private lateinit var binding: FragmentListFriendsBinding
    private val viewModel: LoggedUserViewModel by viewModels()


    fun goToFriendProfile(v:View){
        //findNavController().navigate(R.id.ac)
        Toast.makeText(requireContext(), "foi amigo", Toast.LENGTH_SHORT).show()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListFriendsBinding.inflate(inflater, container, false)
        binding.usersFragment = this
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFriendsList.layoutManager = LinearLayoutManager(context)
        loadUsers()

        viewModel.loadusers.observe(viewLifecycleOwner) { listausers ->
            val adaptador = UsersRecyclerView(listausers)
            binding.rvFriendsList.adapter = adaptador

        }


    }

    fun loadUsers(){
        viewModel.loadAllFriends()
    }



}