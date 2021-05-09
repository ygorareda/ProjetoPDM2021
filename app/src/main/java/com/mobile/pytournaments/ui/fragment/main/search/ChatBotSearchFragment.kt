package com.mobile.pytournaments.ui.fragment.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentChatBotSearchBinding
import com.mobile.pytournaments.databinding.FragmentLoginBinding

class ChatBotSearchFragment : Fragment() {

    private lateinit var biding : FragmentChatBotSearchBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        biding = FragmentChatBotSearchBinding.inflate(inflater, container, false)


        return biding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //cria botão de voltar
        biding.toolbar.setNavigationIcon(R.drawable.ic_back) // need to set the icon here to have a navigation icon. You can simple create an vector image by "Vector Asset" and using here
        biding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.searchFragment)


            // do something when click navigation
        }


    }

}