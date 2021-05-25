package com.mobile.pytournaments.ui.fragment.main.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.ui.adapter.Horizontal_RecyclerView
import com.mobile.pytournaments.databinding.FragmentProfileMainUserBinding
import com.mobile.pytournaments.viewmodel.LoggedUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileMainUserFragment : Fragment() {

    private lateinit var binding: FragmentProfileMainUserBinding
//                         transformar para activityViewModels()
//                          para ter variaveis globais
    private val viewModel: LoggedUserViewModel by viewModels()

    fun redirecionarAmigos(v: View){
        findNavController().navigate(R.id.action_profileMainUserFragment_to_profileFriendUserFragment)
    }
    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileMainUserBinding.inflate(inflater, container, false)
        binding.redirecionar = this
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTorneiosParticipadosProfile.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        viewModel.loggedUser.observe(viewLifecycleOwner) { user ->
            binding.tvNome.text = user.name
            binding.rvTorneiosParticipadosProfile.adapter = Horizontal_RecyclerView(user.tournamentsHistory)
        }

        loadProfileData()
    }

    fun loadProfileData(){
        viewModel.loadLoggedUserData()
    }

}