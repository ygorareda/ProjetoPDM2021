package com.mobile.pytournaments.ui.fragment.main.tournaments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.adapter.Horizontal_RecyclerView
import com.mobile.pytournaments.databinding.FragmentMainTournamentsBinding
import com.mobile.pytournaments.domain.Tournament
import com.mobile.pytournaments.viewmodel.TournamentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainTournamentsFragment : Fragment() {

    private lateinit var binding: FragmentMainTournamentsBinding
    private val viewModel: TournamentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainTournamentsBinding.inflate(inflater, container, false)
        binding.tournamentFragment = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTorneiosOnline.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTorneiosPresenciais.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //codigo com repetição possivelmente tem como utilizar apenas um observe
        viewModel.searchedOnlineTournaments.observe(viewLifecycleOwner) { list ->
            binding.rvTorneiosOnline.adapter = Horizontal_RecyclerView(list)
        }
        viewModel.searchedLocalTournaments.observe(viewLifecycleOwner) { list ->
            binding.rvTorneiosPresenciais.adapter = Horizontal_RecyclerView(list)
        }

        loadTournamentDataOnScreen()
    }

    fun loadTournamentDataOnScreen(){
        viewModel.loadSearchedTournaments()
    }
}