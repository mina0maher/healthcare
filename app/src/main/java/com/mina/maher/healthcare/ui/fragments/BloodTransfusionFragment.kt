package com.mina.maher.healthcare.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.mina.maher.healthcare.R
import com.mina.maher.healthcare.adapters.DropDownAdapter
import com.mina.maher.healthcare.models.ClinicModel
import com.mina.maher.healthcare.utilities.Constants

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
        hospitals.add(ClinicModel("El Sherouk Hospital",R.drawable.shoroq))
        hospitals.add(ClinicModel("Dar Alqmah Hospital",R.drawable.daralqamah))
        hospitals.add(ClinicModel("Ibn Sina Hospital",R.drawable.ibnsinah))
        hospitals.add(ClinicModel("Dar Alshefaa Hospital",R.drawable.daralqamah))
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
                Constants.showToast("Sorry This Blood Type&Group Is Not Available In This Hospital",requireContext())
            }else{
                Constants.showToast("Available",requireContext())
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