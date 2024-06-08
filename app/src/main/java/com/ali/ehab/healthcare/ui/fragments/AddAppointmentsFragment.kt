package com.ali.ehab.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.adapters.DropDownAdapter
import com.ali.ehab.healthcare.models.ClinicModel
import com.ali.ehab.healthcare.utilities.Constants

class AddAppointmentsFragment: Fragment(R.layout.fragment_add_appointment) {
    private val hospitals :ArrayList<ClinicModel> = ArrayList()
    private lateinit var spinner: Spinner
    private lateinit var buttonSignUp: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var radioSat: RadioButton
    private lateinit var radioSun: RadioButton
    private lateinit var radioMon: RadioButton
    private lateinit var radioTue: RadioButton
    private lateinit var radioWed: RadioButton
    private lateinit var radioThu: RadioButton
    private lateinit var radioFri: RadioButton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSignUp = view.findViewById(R.id.buttonConfirm)
        progressBar =view.findViewById(R.id.progressBar)
        radioSat = view.findViewById(R.id.sat)
        radioSun = view.findViewById(R.id.sun)
        radioMon = view.findViewById(R.id.mon)
        radioTue = view.findViewById(R.id.tue)
        radioWed = view.findViewById(R.id.wed)
        radioThu = view.findViewById(R.id.thu)
        radioFri = view.findViewById(R.id.fri)
        spinner = view.findViewById(R.id.hospitalName)
        hospitals.add(ClinicModel("El Sherouk Hospital",R.drawable.shoroq))
        hospitals.add(ClinicModel("Dar Alqmah Hospital",R.drawable.daralqamah))
        hospitals.add(ClinicModel("Ibn Sina Hospital",R.drawable.ibnsinah))
        hospitals.add(ClinicModel("Dar Alshefaa Hospital",R.drawable.daralqamah))
        val dropDownAdapter = DropDownAdapter(requireContext(),hospitals)
        dropDownAdapter.setDropDownViewResource(R.layout.item_dropdown)
        spinner.adapter = dropDownAdapter

        buttonSignUp.setOnClickListener {
            Constants.showToast("done",requireContext())
            requireActivity().onBackPressed()
        }
        radioSat.setOnClickListener {
            radioSat.setTextColor(resources.getColor(R.color.white))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioSun.setOnClickListener {
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.white))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioMon.setOnClickListener {
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.white))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioTue.setOnClickListener {
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.white))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioWed.setOnClickListener {
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.white))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioThu.setOnClickListener {
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.white))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioFri.setOnClickListener {
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.white))
        }
    }
}