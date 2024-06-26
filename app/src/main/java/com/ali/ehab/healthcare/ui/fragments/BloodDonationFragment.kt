package com.ali.ehab.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.adapters.DropDownAdapter
import com.ali.ehab.healthcare.models.ClinicModel
import com.ali.ehab.healthcare.utilities.Constants

class BloodDonationFragment: Fragment(R.layout.fragment_blood_donation) {
    private val hospitals :ArrayList<ClinicModel> = ArrayList()
    private lateinit var hospitalsSpinner: Spinner
    private lateinit var buttonSignUp: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var time: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSignUp = view.findViewById(R.id.buttonSignUp)
        progressBar =view.findViewById(R.id.progressBar)
        hospitalsSpinner = view.findViewById(R.id.hospitalName)
        hospitals.add(ClinicModel(resources.getString(R.string.el_sherouk_hospital),R.drawable.shoroq))
        hospitals.add(ClinicModel(resources.getString(R.string.dar_alqmah_hospital),R.drawable.daralqamah))
        hospitals.add(ClinicModel(resources.getString(R.string.ibn_sina_hospital),R.drawable.ibnsinah))
        hospitals.add(ClinicModel(resources.getString(R.string.dar_alshefaa_hospital),R.drawable.daralqamah))
        val hospitalsAdapter = DropDownAdapter(requireContext(),hospitals)
        hospitalsAdapter.setDropDownViewResource(R.layout.item_dropdown)
        hospitalsSpinner.adapter = hospitalsAdapter
        time = view.findViewById(R.id.inputTo)

        buttonSignUp.setOnClickListener {
            loading(true)
            if(time.text.toString()=="2:00"){
                Constants.showToast(resources.getString(R.string.sorry_this_appointment_is_not_available),requireContext())
            }else{
                Constants.showToast(resources.getString(R.string.done),requireContext())
                requireActivity().onBackPressed()
            }

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
    }}