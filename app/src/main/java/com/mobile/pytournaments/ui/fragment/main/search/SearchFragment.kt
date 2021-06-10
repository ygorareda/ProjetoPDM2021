package com.mobile.pytournaments.ui.fragment.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mobile.pytournaments.R
import com.mobile.pytournaments.ui.adapter.Grid_RecyclerView
import com.mobile.pytournaments.databinding.FragmentSearchBinding
import com.mobile.pytournaments.viewmodel.SharedViewModel
import com.mobile.pytournaments.viewmodel.TournamentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class   SearchFragment : Fragment(), Grid_RecyclerView.OnClickListener {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: TournamentViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    fun irChatBot(v: View) {
        findNavController().navigate(R.id.action_searchFragment_to_chatBotSearchFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.searchFragment = this
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTorneiosSugeridos.layoutManager = GridLayoutManager(context, 2)

        viewModel.suggestedTournaments.observe(viewLifecycleOwner){ list ->
            binding.rvTorneiosSugeridos.adapter = Grid_RecyclerView(list, this@SearchFragment)
        }

        searchForTournamentsUsingUserPreferences()
    }

    fun searchForTournamentsUsingUserPreferences(){
        viewModel.loadSuggestedTournaments()
    }

    override fun onRecycleViewClick(position: Int) {
        viewModel.suggestedTournaments.value?.get(position)?.let { sharedViewModel.selectItem(it) }
        findNavController().navigate(R.id.action_searchFragment_to_tournamentsDescriptionFragment)
    }
}