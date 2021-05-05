package com.mobile.pytournaments.ui.fragment.main.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.pytournaments.R
import com.mobile.pytournaments.ui.fragment.main.MainFragment


class ProfileMainUserFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_main_user, container, false)
    }

    companion object {
        fun newInstance(): ProfileMainUserFragment = ProfileMainUserFragment()
    }


}