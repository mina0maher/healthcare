package com.mina.maher.healthcare.ui.fragments

import android.app.Dialog
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mina.maher.healthcare.R
import com.mina.maher.healthcare.utilities.Constants
import com.mina.maher.healthcare.utilities.PreferenceManager

class LoginFragment : Fragment(R.layout.fragment_login) {
    //declare views

    private lateinit var buttonSignIn :Button
    private lateinit var progressBar: ProgressBar
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var textCreateNewAccount:TextView
    private lateinit var preferenceManager: PreferenceManager
    private var isLoginClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //handle enter & exit animation
        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
        if(savedInstanceState!=null){
            isLoginClicked = savedInstanceState.getBoolean(Constants.KEY_IS_LOGIN_CLICKED)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(Constants.KEY_IS_LOGIN_CLICKED,isLoginClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //init views
        preferenceManager = PreferenceManager(requireActivity())
        textCreateNewAccount = view.findViewById(R.id.textCreateNewAccount)
        buttonSignIn =view.findViewById(R.id.buttonSignIn)
        inputEmail = view.findViewById(R.id.inputEmail)
        inputPassword = view.findViewById(R.id.inputPassword)
        progressBar = view.findViewById(R.id.progressBar)
        if(isLoginClicked){
            signIn()
        }
        setListeners()
    }

    private fun setListeners(){
        textCreateNewAccount.setOnClickListener{
            //navigate from login to signup
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
        buttonSignIn.setOnClickListener{
            loading(true)
            if (isValidSignInDetails()) {

                    signIn()

            }else{
                loading(false)
            }
        }
    }
    private fun isValidSignInDetails():Boolean
    {
        return if (inputEmail.text.toString().trim().isEmpty()) {
            Constants.showToast("Enter email", requireActivity())
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.text.toString())
                .matches()
        ) {
            Constants.showToast("Enter valid email", requireActivity())
            false
        } else if (inputPassword.text.toString().trim().isEmpty()) {
            Constants.showToast("Enter password", requireActivity())
            false
        } else {
            true
        }
    }
    private fun loading(isLoading: Boolean) {
        if (isLoading) {
            buttonSignIn.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.INVISIBLE
            buttonSignIn.visibility = View.VISIBLE
        }
    }

    private fun signIn(){

        isLoginClicked = true
        if(inputEmail.text.toString() == "ahmed@gmail.com" &&
             inputPassword.text.toString() == "123456"){
                    preferenceManager.putBoolean(Constants.KEY_PATIENT_IS_SIGNED, true)
                    findNavController().navigate(R.id.action_loginFragment_to_patientFragment)
                    preferenceManager.putString(Constants.KEY_USER_NAME,"ahmed")
                    loading(false)
        }else if(inputEmail.text.toString() == "ahmed@gmail.com" &&
            inputPassword.text.toString() == "123456"){
                    preferenceManager.putBoolean(Constants.KEY_DOCTOR_IS_SIGNED, true)
                    preferenceManager.putString(Constants.KEY_USER_NAME,"ahmed")
                    findNavController().navigate(R.id.action_loginFragment_to_doctorDashboardFragment)
                    loading(false)
        }else{
            Constants.showToast("email & password not correct", requireActivity())
            loading(false)
            isLoginClicked=false
        }

    }


}