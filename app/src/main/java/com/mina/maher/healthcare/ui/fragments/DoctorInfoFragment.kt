package com.mina.maher.healthcare.ui.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.makeramen.roundedimageview.RoundedImageView
import com.mina.maher.healthcare.R
import com.mina.maher.healthcare.adapters.DropDownAdapter
import com.mina.maher.healthcare.models.ClinicModel
import com.mina.maher.healthcare.utilities.Constants
import com.mina.maher.healthcare.utilities.PreferenceManager
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.InputStream


class DoctorInfoFragment : Fragment(R.layout.fragment_doctor_info) {
    private lateinit var preferenceManager: PreferenceManager
    private lateinit var imageProfile:RoundedImageView
    private lateinit var textAddImage:TextView
    private lateinit var layoutImage: FrameLayout
    private lateinit var inputPhone: EditText
    private var encodedImage = ""
    private val CLINICS :ArrayList<ClinicModel> = ArrayList()
    private lateinit var autoCompleteTextView: Spinner

    private lateinit var buttonSignUp: Button
    private lateinit var progressBar: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager = PreferenceManager(requireActivity())
        imageProfile = view.findViewById(R.id.imageProfile)
        textAddImage = view.findViewById(R.id.textAddImage)
        layoutImage = view.findViewById(R.id.layoutImage)
        buttonSignUp = view.findViewById(R.id.buttonSignUp)
        progressBar =view.findViewById(R.id.progressBar)
        inputPhone = view.findViewById(R.id.inputPhone)
        autoCompleteTextView = view.findViewById(R.id.clinicName)
        layoutImage.setOnClickListener { v: View? ->
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            pickImage.launch(intent)
        }
        CLINICS.add(ClinicModel("Endocrinology",R.drawable.endocrinology))
        CLINICS.add(ClinicModel("Cardiology",R.drawable.cardiology))
        CLINICS.add(ClinicModel("Ophthalmology",R.drawable.ophthalmology))
        CLINICS.add(ClinicModel("Pediatrics",R.drawable.pediatrics))
        CLINICS.add(ClinicModel("Dermatology",R.drawable.dermatology))
        CLINICS.add(ClinicModel("neurology",R.drawable.neurology))
        CLINICS.add(ClinicModel("Dentistry",R.drawable.dentistry))
        CLINICS.add(ClinicModel("Psychiatry",R.drawable.psychiatry))
        val dropDownAdapter = DropDownAdapter(requireContext(),CLINICS)
        dropDownAdapter.setDropDownViewResource(R.layout.item_dropdown)
        autoCompleteTextView.adapter = dropDownAdapter

        buttonSignUp.setOnClickListener {
            loading(true)
            if(inputPhone.text.isNotEmpty()) {
                preferenceManager.putString(Constants.KEY_CLINIC_NAME, autoCompleteTextView.selectedItemId.toString())
                preferenceManager.putString(Constants.KEY_PHONE, inputPhone.text.toString())
                preferenceManager.putBoolean(Constants.KEY_DOCTOR_IS_SIGNED, true)
                findNavController().navigate(R.id.action_doctorInfoFragment_to_doctorDashboardFragment)
            }else{
                Constants.showToast("Enter Phone", requireContext())
            }
            loading(false)
        }


    }








    private val pickImage = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            if (result.data != null) {
                val imageUri = result.data!!.data
                try {
                    val inputStream: InputStream? =
                        requireActivity().contentResolver.openInputStream(imageUri!!)
                    val bitmap =
                        BitmapFactory.decodeStream(inputStream)
                    imageProfile.setImageBitmap(bitmap)
                    textAddImage.visibility = View.GONE
                    encodedImage = encodeImage(bitmap)
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
            }
        }
    }
    private fun encodeImage(bitmap: Bitmap): String {
        val previewWidth = 150
        val previewHeight = bitmap.height * previewWidth / bitmap.width
        val previewBitmap = Bitmap.createScaledBitmap(bitmap, previewWidth, previewHeight, false)
        val byteArrayOutputStream = ByteArrayOutputStream()
        previewBitmap.compress(Bitmap.CompressFormat.JPEG, 99, byteArrayOutputStream)
        val bytes = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
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