package com.ali.ehab.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.adapters.AppointmentAdapter
import com.ali.ehab.healthcare.models.AppointmentModel

class MyAppointmentsFragment:Fragment(R.layout.fragment_my_appointments) {
    private lateinit var recyclerView:RecyclerView
    private val appointments :ArrayList<AppointmentModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appointments.add(AppointmentModel("ali nader","friday from: 2:00pm to 2:30pm","cairo international hospital"))
        appointments.add(AppointmentModel("ahmed zein","friday from: 2:30pm to 3:00pm","cairo international hospital"))
        appointments.add(AppointmentModel("mina maher","friday from: 3:30pm to 4:00pm","cairo international hospital"))
        appointments.add(AppointmentModel("shady alsawy","friday from: 4:00pm to 4:30pm","cairo international hospital"))

        recyclerView = view.findViewById(R.id.scrollView2)
        recyclerView.adapter=AppointmentAdapter(appointments)


    }
}