package com.ali.ehab.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.adapters.DropDownAdapter
import com.ali.ehab.healthcare.models.ClinicModel
import com.ali.ehab.healthcare.utilities.Constants

class BloodTransfusionFragment: Fragment(R.layout.fragment_blood_transfusion) {

    private val hospitals :ArrayList<ClinicModel> = ArrayList()
    private lateinit var hospitalsSpinner: Spinner
    private val types :ArrayList<ClinicModel> = ArrayList()
    private lateinit var typesSpinner: Spinner
    private val groups :ArrayList<ClinicModel> = ArrayList()
    private lateinit var groupsSpinner: Spinner
    private lateinit var buttonSignUp: Button
    private lateinit var progressBar: ProgressBar
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

        typesSpinner = view.findViewById(R.id.bloodType)
        types.add(ClinicModel("A",R.drawable.type))
        types.add(ClinicModel("B",R.drawable.type))
        types.add(ClinicModel("AB",R.drawable.type))
        types.add(ClinicModel("O",R.drawable.type))
        val typesAdapter = DropDownAdapter(requireContext(),types)
        typesAdapter.setDropDownViewResource(R.layout.item_dropdown)
        typesSpinner.adapter=typesAdapter

        groupsSpinner = view.findViewById(R.id.bloodGroup)
        groups.add(ClinicModel("+",R.drawable.group))
        groups.add(ClinicModel("-",R.drawable.group))

        val groupsAdapter = DropDownAdapter(requireContext(),groups)
        groupsAdapter.setDropDownViewResource(R.layout.item_dropdown)
        groupsSpinner.adapter=groupsAdapter
        buttonSignUp.setOnClickListener {
            loading(true)
            if(hospitalsSpinner.selectedItemId == 1L&&
                typesSpinner.selectedItemId==1L&&
                groupsSpinner.selectedItemId==1L){
                Constants.showToast(resources.getString(R.string.sorry_this_blood_type),requireContext())
            }else{
                Constants.showToast(resources.getString(R.string.available),requireContext())
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
    }
}