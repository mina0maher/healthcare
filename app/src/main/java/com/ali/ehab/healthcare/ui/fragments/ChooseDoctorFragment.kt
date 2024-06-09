package com.ali.ehab.healthcare.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.adapters.DropDownAdapter
import com.ali.ehab.healthcare.models.ClinicModel
import com.ali.ehab.healthcare.utilities.Constants
import com.ali.ehab.healthcare.utilities.PreferenceManager


class ChooseDoctorFragment: Fragment(R.layout.fragment_choose_doctor) {
    private val doctors :ArrayList<ClinicModel> = ArrayList()
    private lateinit var doctorsSpinner: Spinner
    private lateinit var time: EditText
    private lateinit var buttonSignUp: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var preferenceManager: PreferenceManager
    private lateinit var dialog: Dialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = Dialog(requireContext())
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
                Constants.showToast(resources.getString(R.string.sorry_this_appointment_is_not_available),requireContext())
            }else{

                Constants.showToast("done",requireContext())
                openConfirmationDialog(preferenceManager.getString(Constants.KEY_DAY)+","+time.text.toString()+"\n"
                                            +preferenceManager.getString(Constants.KEY_HOSPITAL)+"\n"
                                              +preferenceManager.getString(Constants.KEY_CLINIC)+"\n"
                                                +doctors.get(doctorsSpinner.selectedItemId.toInt()).name)
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
    private fun openConfirmationDialog(text:String) {
        dialog.setContentView(R.layout.confirmation_dialog_layout)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val textView: TextView = dialog.findViewById(R.id.textDismiss)
        val ticketsText: TextView = dialog.findViewById(R.id.ticket_text)
        ticketsText.text=text
        val button: Button = dialog.findViewById(R.id.buttonSeeGates)
        textView.setOnClickListener {
            dialog.dismiss()
            Constants.showToast("Deleted",requireContext())
        }
        button.setOnClickListener {
            dialog.dismiss()
            findNavController().navigate(R.id.action_chooseDoctorFragment_to_patientFragment)
        }
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.80).toInt()
        dialog.window!!.setLayout(width, height)
        dialog.setCancelable(false)
        dialog.show()
    }
}