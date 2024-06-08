package com.ali.ehab.healthcare.utilities
import android.content.Context
import android.widget.Toast


object Constants {
    const val KEY_DOCTOR_IS_SIGNED = "doctorIsSignedIn"
    const val KEY_PATIENT_IS_SIGNED = "patientIsSignedIn"
    const val KEY_USER_NAME="userName"
    const val KEY_CLINIC_NAME="clinicName"
    const val KEY_PHONE="phone"
    const val KEY_PREFERENCE_NAME = "marketXPreference"
    const val KEY_IS_LOGIN_CLICKED = "isLoginClicked"
    const val KEY_IS_SIGNUP_CLICKED = "isSignUpClicked"
    const val KEY_CLINIC="clinic"
    const val KEY_DAY="day"
    const val KEY_HOSPITAL="hospital"
    private var toast: Toast? = null



    fun showToast(message: String,context: Context) {
        if(toast !=null){
            toast!!.cancel()

        }
        toast =  Toast.makeText(context,message,Toast.LENGTH_SHORT)
        toast!!.show()
    }





}