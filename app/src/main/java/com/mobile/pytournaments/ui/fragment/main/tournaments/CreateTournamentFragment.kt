package com.mobile.pytournaments.ui.fragment.main.tournaments

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentCreateTournamentBinding
import com.mobile.pytournaments.viewmodel.CreateTournamentViewModel


class CreateTournamentFragment : Fragment(), DatePickerDialog.OnDateSetListener{

    private lateinit var binding: FragmentCreateTournamentBinding
    private val viewModel: CreateTournamentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateTournamentBinding.inflate(inflater,container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.fragment = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.checkboxValue.value = false
        viewModel.result.observe(viewLifecycleOwner){
            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()

            if(it.success){
                findNavController().navigate(R.id.action_createTournamentFragment_to_mainTournamentsFragment)
            }
        }


    }

    fun registerTournament(v: View){
       Toast.makeText(context, "${viewModel.date.value}|${viewModel.time.value}",Toast.LENGTH_SHORT).show()
       viewModel.registerTournament()
    }

    fun onClickCheckbox(v: View){
        viewModel.clickOnCheckbox()
    }

    fun goToMap(v: View){
        findNavController().navigate(R.id.action_createTournamentFragment_to_mapsFragment)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        TODO("Not yet implemented")
    }
}