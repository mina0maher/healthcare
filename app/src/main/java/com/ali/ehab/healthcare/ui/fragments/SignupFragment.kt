package com.ali.ehab.healthcare.ui.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ali.ehab.healthcare.R
import com.ali.ehab.healthcare.utilities.Constants
import com.ali.ehab.healthcare.utilities.Constants.KEY_IS_SIGNUP_CLICKED
import com.ali.ehab.healthcare.utilities.Constants.showToast
import com.ali.ehab.healthcare.utilities.PreferenceManager


class SignupFragment : Fragment(R.layout.fragment_signup) {
    //declare views
    private lateinit var inputName: EditText
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var inputConfirmPassword: EditText
    private lateinit var buttonSignUp:Button
    private lateinit var textSignIn: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var radioDoctor:RadioButton
    private lateinit var radioClient:RadioButton
    //
    private lateinit var preferenceManager: PreferenceManager
    //vars
    private var isSignUpClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //handle enter & exit animation
        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation

        //save state
        if(savedInstanceState!=null){
            isSignUpClicked = savedInstanceState.getBoolean(KEY_IS_SIGNUP_CLICKED)
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init views
        preferenceManager = PreferenceManager(requireActivity())
        inputName = view.findViewById(R.id.inputName)
        inputEmail = view.findViewById(R.id.inputEmail)
        inputPassword = view.findViewById(R.id.inputPassword)
        inputConfirmPassword = view.findViewById(R.id.inputConfirmPassword)
        buttonSignUp = view.findViewById(R.id.buttonSignUp)
        textSignIn = view.findViewById(R.id.textSignIn)
        progressBar =view.findViewById(R.id.progressBar)
        radioDoctor = view.findViewById(R.id.radioDoctor)
        radioClient = view.findViewById(R.id.radioClient)
        setListeners()

        if(isSignUpClicked){
            signUp()
        }

    }


    private fun setListeners(){
        textSignIn.setOnClickListener{
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }
        buttonSignUp.setOnClickListener {
            loading(true)
            if (isValidSignUpDetails()) {
                    signUp()

            }else{
                loading(false)
            }
        }
        radioDoctor.setOnClickListener {
            radioDoctor.isChecked=true
            radioClient.isChecked=false
            radioDoctor.setTextColor(resources.getColor(R.color.white))
            radioClient.setTextColor(resources.getColor(R.color.primary_light))
        }
        radioClient.setOnClickListener {
            radioClient.isChecked=true
            radioDoctor.isChecked=false
            radioClient.setTextColor(resources.getColor(R.color.white))
            radioDoctor.setTextColor(resources.getColor(R.color.primary_light))
        }
    }

    private fun signUp(){

            isSignUpClicked = true
            loading(true)
        if (radioClient.isChecked){
            findNavController().navigate(R.id.action_signupFragment_to_patientFragment)
            preferenceManager.putBoolean(Constants.KEY_PATIENT_IS_SIGNED,true)
        }else{
            findNavController().navigate(R.id.action_signupFragment_to_doctorInfoFragment)
        }
        preferenceManager.putString(Constants.KEY_USER_NAME,inputName.text.toString())
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

    private fun isValidSignUpDetails(): Boolean {
        return if (inputName.text.toString().trim().isEmpty()) {
            showToast(resources.getString(R.string.enter_name),requireContext())
            false
        } else if (inputEmail.text.toString().trim().isEmpty()) {
            showToast(resources.getString(R.string.enter_email),requireContext())
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.text.toString())
                .matches()
        ) {
            showToast(resources.getString(R.string.enter_valid_email),requireContext())
            false
        } else if (inputPassword.text.toString().trim().isEmpty()) {
            showToast(resources.getString(R.string.enter_password),requireContext())
            false
        } else if (inputConfirmPassword.text.toString().trim().isEmpty()) {
            showToast(resources.getString(R.string.confirm_your_password),requireContext())
            false
        } else if (inputPassword.text.toString() != inputConfirmPassword.text.toString()) {
            showToast(resources.getString(R.string.password_confirm_password_must_be_same),requireContext())
            false
        } else {
            true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_IS_SIGNUP_CLICKED,isSignUpClicked)
    }



}