package com.mina.maher.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mina.maher.healthcare.R
import com.mina.maher.healthcare.utilities.PreferenceManager

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
        setViewsData()
        myAppointmentsView.setOnClickListener {
            findNavController().navigate(R.id.action_doctorDashboardFragment_to_myAppointmentsFragment)
        }
    }
    private fun setViewsData(){
        val addAppointmentsText = addAppointmentsView.findViewById<TextView>(R.id.title)
        val myAppointmentsText = myAppointmentsView.findViewById<TextView>(R.id.title)
        val addAppointmentsImage = addAppointmentsView.findViewById<ImageView>(R.id.thumbnail)
        val myAppointmentsImage = myAppointmentsView.findViewById<ImageView>(R.id.thumbnail)
        addAppointmentsText.text = "Add Appointments"
        myAppointmentsText.text = "My Appointments"
        addAppointmentsImage.setImageResource(R.drawable.add_appointments)
        myAppointmentsImage.setImageResource(R.drawable.my_appointments)
    }
}