package com.ali.ehab.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.utilities.Constants
import com.ali.ehab.healthcare.utilities.PreferenceManager

class DoctorDashboardFragment:Fragment(R.layout.fragment_doctor_dashboard) {
    private lateinit var welcomeText: TextView
    private lateinit var addAppointmentsView: View
    private lateinit var myAppointmentsView: View
    private lateinit var signOutImage : ImageView
    private lateinit var moreImage: ImageView
    private lateinit var preferenceManager: PreferenceManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager = PreferenceManager(requireActivity())
        welcomeText = view.findViewById(R.id.welcome_text)
        addAppointmentsView = view.findViewById(R.id.addAppointments)
        myAppointmentsView = view.findViewById(R.id.myAppointments)
        signOutImage = view.findViewById(R.id.imageSignOut)
        moreImage = view.findViewById(R.id.imageMore)
        welcomeText.text="${resources.getString(R.string.welcome_dr)}${preferenceManager.getString(Constants.KEY_USER_NAME)}!"

        setViewsData()
        myAppointmentsView.setOnClickListener {
            findNavController().navigate(R.id.action_doctorDashboardFragment_to_myAppointmentsFragment)
        }
        addAppointmentsView.setOnClickListener {
            findNavController().navigate(R.id.action_doctorDashboardFragment_to_addAppointmentsFragment)
        }
        signOutImage.setOnClickListener{
            preferenceManager.clear()
            findNavController().navigate(R.id.action_doctorDashboardFragment_to_startFragment)
        }
    }
    private fun setViewsData(){
        val addAppointmentsText = addAppointmentsView.findViewById<TextView>(R.id.title)
        val myAppointmentsText = myAppointmentsView.findViewById<TextView>(R.id.title)
        val addAppointmentsImage = addAppointmentsView.findViewById<ImageView>(R.id.thumbnail)
        val myAppointmentsImage = myAppointmentsView.findViewById<ImageView>(R.id.thumbnail)
        addAppointmentsText.text = resources.getString(R.string.add_appointments)
        myAppointmentsText.text = resources.getString(R.string.my_appointments)
        addAppointmentsImage.setImageResource(R.drawable.add_appointments)
        myAppointmentsImage.setImageResource(R.drawable.my_appointments)
    }
}