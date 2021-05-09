package com.mobile.pytournaments.ui.fragment.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.adapter.Grid_RecyclerView
import com.mobile.pytournaments.databinding.FragmentMainBinding
import com.mobile.pytournaments.databinding.FragmentSearchBinding

class   SearchFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Grid_RecyclerView
    private lateinit var biding: FragmentSearchBinding

    fun irChatBot(v: View) {
        findNavController().navigate(R.id.action_searchFragment_to_chatBotSearchFragment)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        biding = FragmentSearchBinding.inflate(inflater, container, false)
        biding.teste = this
        biding.lifecycleOwner = this

        //recycler view lista
        recyclerView = biding.rvRoalegmTorneiosParticipados
        adapter = Grid_RecyclerView()

        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.adapter = adapter




        return biding.root
    }


}