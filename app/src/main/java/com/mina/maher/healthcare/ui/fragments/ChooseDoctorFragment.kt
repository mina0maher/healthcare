package com.mina.maher.healthcare.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mina.maher.healthcare.R
import com.mina.maher.healthcare.adapters.DropDownAdapter
import com.mina.maher.healthcare.models.ClinicModel
import com.mina.maher.healthcare.utilities.Constants
import com.mina.maher.healthcare.utilities.PreferenceManager


class ChooseDoctorFragment: Fragment(R.layout.fragment_choose_doctor) {
    private val doctors :ArrayList<ClinicModel> = ArrayList()
    private lateinit var doctorsSpinner: Spinner
    private lateinit var time: EditText
    private lateinit var buttonSignUp: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var preferenceManager: PreferenceManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager = PreferenceManager(requireActivity())
        buttonSignUp = view.findViewById(R.id.buttonSignUp)
        progressBar =view.findViewById(R.id.progressBar)
        doctors.add(ClinicModel("Ahmed Lotfy",R.drawable.ahmed_lotfy_elgamal))
        doctors.add(ClinicModel("Amira Elsaid",R.drawable.amira_elsaid))
        doctors.add(ClinicModel("Maged Elwakeel",R.drawable.maged_elwakeel))
        doctors.add(ClinicModel("Mohamed Farid",R.drawable.mohamed_farid))
        doctors.add(ClinicModel("muhamad Almessery",R.drawable.muhammad_almessry))
        doctors.add(ClinicModel("Omar Elomairy",R.drawable.omar_elomairy))
        doctorsSpinner = view.findViewById(R.id.doctorName)
        val doctorsAdapter = DropDownAdapter(requireContext(),doctors)
        doctorsAdapter.setDropDownViewResource(R.layout.item_dropdown)
        doctorsSpinner.adapter = doctorsAdapter
        time = view.findViewById(R.id.inputTo)

        buttonSignUp.setOnClickListener {
            loading(true)
            if(time.text.toString()=="2:00"){
                Constants.showToast("Sorry this appointment is not available",requireContext())
            }else{
                preferenceManager.putString(Constants.KEY_TIME,time.text.toString())
                preferenceManager.putString(Constants.KEY_DOCTOR,doctorsSpinner.toString())
                Constants.showToast("done",requireContext())
                findNavController().navigate(R.id.action_chooseDoctorFragment_to_patientFragment)
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