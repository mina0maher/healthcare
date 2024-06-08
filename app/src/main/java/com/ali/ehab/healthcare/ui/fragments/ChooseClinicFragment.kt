package com.ali.ehab.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.adapters.DropDownAdapter
import com.ali.ehab.healthcare.models.ClinicModel
import com.ali.ehab.healthcare.utilities.Constants
import com.ali.ehab.healthcare.utilities.PreferenceManager

class ChooseClinicFragment: Fragment(R.layout.fragment_choose_clinic) {
    private val hospitals :ArrayList<ClinicModel> = ArrayList()
    private lateinit var hospitalsSpinner: Spinner
    private lateinit var buttonSignUp: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var radioSat: RadioButton
    private lateinit var radioSun: RadioButton
    private lateinit var radioMon: RadioButton
    private lateinit var radioTue: RadioButton
    private lateinit var radioWed: RadioButton
    private lateinit var radioThu: RadioButton
    private lateinit var radioFri: RadioButton
    private val clinics :ArrayList<ClinicModel> = ArrayList()
    private lateinit var clinicsSpinner: Spinner
    private lateinit var preferenceManager: PreferenceManager
    private var day="Friday"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager = PreferenceManager(requireActivity())
        radioSat = view.findViewById(R.id.sat)
        radioSun = view.findViewById(R.id.sun)
        radioMon = view.findViewById(R.id.mon)
        radioTue = view.findViewById(R.id.tue)
        radioWed = view.findViewById(R.id.wed)
        radioThu = view.findViewById(R.id.thu)
        radioFri = view.findViewById(R.id.fri)
        buttonSignUp = view.findViewById(R.id.buttonSignUp)
        progressBar =view.findViewById(R.id.progressBar)
        clinicsSpinner = view.findViewById(R.id.clinicName)
        clinics.add(ClinicModel("Endocrinology",R.drawable.endocrinology))
        clinics.add(ClinicModel("Cardiology",R.drawable.cardiology))
        clinics.add(ClinicModel("Ophthalmology",R.drawable.ophthalmology))
        clinics.add(ClinicModel("Pediatrics",R.drawable.pediatrics))
        clinics.add(ClinicModel("Dermatology",R.drawable.dermatology))
        clinics.add(ClinicModel("neurology",R.drawable.neurology))
        clinics.add(ClinicModel("Dentistry",R.drawable.dentistry))
        clinics.add(ClinicModel("Psychiatry",R.drawable.psychiatry))
        val clinicsAdapter = DropDownAdapter(requireContext(),clinics)
        clinicsAdapter.setDropDownViewResource(R.layout.item_dropdown)
        clinicsSpinner.adapter = clinicsAdapter


        hospitalsSpinner = view.findViewById(R.id.hospitalName)
        hospitals.add(ClinicModel("El Sherouk Hospital",R.drawable.shoroq))
        hospitals.add(ClinicModel("Dar Alqmah Hospital",R.drawable.daralqamah))
        hospitals.add(ClinicModel("Ibn Sina Hospital",R.drawable.ibnsinah))
        hospitals.add(ClinicModel("Dar Alshefaa Hospital",R.drawable.daralqamah))
        val hospitalsAdapter = DropDownAdapter(requireContext(),hospitals)
        hospitalsAdapter.setDropDownViewResource(R.layout.item_dropdown)
        hospitalsSpinner.adapter = hospitalsAdapter
        radioSat.setOnClickListener {
            day="Saturday"
            radioSat.setTextColor(resources.getColor(R.color.white))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioSun.setOnClickListener {
            day="Sunday"
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.white))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioMon.setOnClickListener {
            day="Monday"
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.white))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioTue.setOnClickListener {
            day="Tuesday"
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.white))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioWed.setOnClickListener {
            day="wednesday"
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.white))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioThu.setOnClickListener {
            day="Thursday"
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.white))
            radioFri.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioFri.setOnClickListener {
            day="Friday"
            radioSat.setTextColor(resources.getColor(R.color.primary_light))
            radioSun.setTextColor(resources.getColor(R.color.primary_light))
            radioMon.setTextColor(resources.getColor(R.color.primary_light))
            radioTue.setTextColor(resources.getColor(R.color.primary_light))
            radioWed.setTextColor(resources.getColor(R.color.primary_light))
            radioThu.setTextColor(resources.getColor(R.color.primary_light))
            radioFri.setTextColor(resources.getColor(R.color.white))
        }
        buttonSignUp.setOnClickListener {
            loading(true)
            preferenceManager.putString(Constants.KEY_DAY,day)
            preferenceManager.putString(Constants.KEY_HOSPITAL,hospitalsAdapter.getItem(hospitalsSpinner.selectedItemId.toInt())!!.name)
            preferenceManager.putString(Constants.KEY_CLINIC,clinicsAdapter.getItem(clinicsSpinner.selectedItemId.toInt())!!.name)
            findNavController().navigate(R.id.action_chooseClinicFragment_to_chooseDoctorFragment)
            loading(false)

        }
    }
    private fun loading(isLoading: Boolean) {
        if (isLoading) {
            buttonSignUp.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.INVISIBLE
            buttonSignUp.visibility = View.VISIBLE
        }
    }
}