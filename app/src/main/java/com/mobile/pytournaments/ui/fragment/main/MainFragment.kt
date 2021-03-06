package com.mobile.pytournaments.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentMainBinding
import com.mobile.pytournaments.ui.adapter.Grid_RecyclerView
import com.mobile.pytournaments.viewmodel.SharedViewModel
import com.mobile.pytournaments.viewmodel.TournamentViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.stream.Collector

@AndroidEntryPoint
class MainFragment : Fragment(), Grid_RecyclerView.OnClickListener{
    private lateinit var binding: FragmentMainBinding

    private val viewModel: TournamentViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()


    fun goToTournamentScreen(v : View){
        viewModel.subscribedTournaments.value?.get(0)?.let { sharedViewModel.selectItem(it) }
        findNavController().navigate(R.id.action_mainFragment_to_tournamentsDescriptionFragment)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.mainFragment = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.rvTorneiosParticipados.layoutManager = GridLayoutManager(context, 2)

        try {

            viewModel.subscribedTournaments.observe(viewLifecycleOwner) { list ->
                binding.titulo.text = list[0].name
                binding.descricaoJogo.text = list[0].description
                binding.TournamentDate.text = list[0].getStringDate()

                binding.rvTorneiosParticipados.adapter =
                    Grid_RecyclerView(list.slice(1 until list.size), this@MainFragment)

            }
            loadSubscribedTournaments()
        }
        catch(e : Exception){
            Toast.makeText(context, "Ocorreu algum erro ao carregar os torneios!!", Toast.LENGTH_SHORT).show()
            println(e.printStackTrace())
        }
    }

    fun loadSubscribedTournaments(){
        viewModel.loadSubscribedTournaments()
    }

    override fun onRecycleViewClick(position: Int) {
        viewModel.subscribedTournaments.value?.get(position+1)?.let { sharedViewModel.selectItem(it) }
        findNavController().navigate(R.id.action_mainFragment_to_tournamentsDescriptionFragment)
    }


}