package com.mina.maher.healthcare.utilities
import android.content.Context
import android.widget.Toast
import com.mina.maher.healthcare.models.ClinicModel
import java.security.Key


object Constants {
    const val KEY_DOCTOR_IS_SIGNED = "doctorIsSignedIn"
    const val KEY_PATIENT_IS_SIGNED = "patientIsSignedIn"
    const val KEY_USER_NAME="userName"
    const val KEY_CLINIC_NAME="clinicName"
    const val KEY_PHONE="phone"
    const val KEY_USER_PASSWORD="userPassword"
    const val KEY_PREFERENCE_NAME = "marketXPreference"
    const val KEY_HOME_SAVED_INSTANCE = "homeSavedInstance"
    const val KEY_PRODUCT_SAVED_INSTANCE = "productSavedInstance"
    const val KEY_RECYCLER_SAVED_INSTANCE = "recyclerSavedInstance"
    const val KEY_IS_LOGIN_CLICKED = "isLoginClicked"
    const val KEY_IS_SIGNUP_CLICKED = "isSignUpClicked"
    const val KEY_IS_VERIFIED="isVerified"
    const val KEY_CLINIC="clinic"
    const val KEY_DAY="day"
    const val KEY_HOSPITAL="hospital"
    const val KEY_DOCTOR=""
    const val KEY_TIME=""
    private var toast: Toast? = null



    fun showToast(message: String,context: Context) {
        if(toast !=null){
            toast!!.cancel()

        }
        toast =  Toast.makeText(context,message,Toast.LENGTH_SHORT)
        toast!!.show()
    }





}