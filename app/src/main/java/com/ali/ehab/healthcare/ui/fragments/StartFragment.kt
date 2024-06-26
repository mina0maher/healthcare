package com.ali.ehab.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController

import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.utilities.Constants
import com.ali.ehab.healthcare.utilities.PreferenceManager


class StartFragment : Fragment(R.layout.fragment_start) {
    //declare views
    private lateinit var signUpButton: Button
    private lateinit var logoImage:ImageView
    private lateinit var linearLayout: LinearLayout
    private lateinit var preferenceManager: PreferenceManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init views
        preferenceManager = PreferenceManager(requireActivity())
        if(preferenceManager.getBoolean(Constants.KEY_DOCTOR_IS_SIGNED)){
            findNavController().navigate(R.id.action_startFragment_to_doctorDashboardFragment)
        }else if (preferenceManager.getBoolean(Constants.KEY_PATIENT_IS_SIGNED)){
            findNavController().navigate(R.id.action_startFragment_to_patientFragment)
        }
        signUpButton = view.findViewById(R.id.buttonSignUp)
        logoImage = view.findViewById(R.id.ImageView)
        linearLayout = view.findViewById(R.id.linearLayout)

        setListeners()

    }
    private fun setListeners(){
        signUpButton.setOnClickListener{
            val extras = FragmentNavigatorExtras(logoImage to "imageSmall")
            findNavController().navigate(
                R.id.action_startFragment_to_signupFragment,
                null,
                null,
                extras
            )
        }
        linearLayout.setOnClickListener{
            val extras = FragmentNavigatorExtras(logoImage to "image_small")
            findNavController().navigate(
                R.id.action_startFragment_to_loginFragment,
                null,
                null,
                extras
            )
        }
    }
}