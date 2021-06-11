package com.mobile.pytournaments.ui.fragment.main.tournaments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.pytournaments.R
import com.mobile.pytournaments.ui.adapter.Horizontal_RecyclerView
import com.mobile.pytournaments.databinding.FragmentMainTournamentsBinding
import com.mobile.pytournaments.ui.adapter.UsersRecyclerView
import com.mobile.pytournaments.viewmodel.LoggedUserViewModel
import com.mobile.pytournaments.viewmodel.SharedViewModel
import com.mobile.pytournaments.viewmodel.TournamentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainTournamentsFragment : Fragment(), Horizontal_RecyclerView.OnClickListener {

    private lateinit var binding: FragmentMainTournamentsBinding
    private val viewModel: TournamentViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    //private val viewModel: LoggedUserViewModel by viewModels()


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
            binding.rvTorneiosOnline.adapter = Horizontal_RecyclerView(list,
                this@MainTournamentsFragment)
        }
        viewModel.searchedLocalTournaments.observe(viewLifecycleOwner) { list ->
            binding.rvTorneiosPresenciais.adapter = Horizontal_RecyclerView(list,
                this@MainTournamentsFragment)
        }

        /*viewModel.loadusers.observe(viewLifecycleOwner){ listausers ->
            val adaptador = UsersRecyclerView(listausers)
            binding.rvTorneiosOnline.adapter = adaptador

        }*/

        loadTournamentDataOnScreen()
    }

   private fun loadTournamentDataOnScreen(){
        viewModel.loadSearchedTournaments()
   }

   override fun onClick(position: Int) {
       viewModel.searchedLocalTournaments.value?.get(position)?.let { sharedViewModel.selectItem(it) }
       findNavController().navigate(R.id.action_mainTournamentsFragment_to_tournamentsDescriptionFragment)
   }

    fun goToCreateTournament(v:View){
        findNavController().navigate(R.id.action_mainTournamentsFragment_to_createTournamentFragment)
    }
}