package com.mina.maher.healthcare.ui.fragments

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mina.maher.healthcare.R
import com.mina.maher.healthcare.utilities.Constants
import com.mina.maher.healthcare.utilities.PreferenceManager
import java.util.Locale


class PatientFragment:Fragment(R.layout.fragment_patient) {
    private lateinit var welcomeText:TextView
    private lateinit var clinicsView:View
    private lateinit var bloodTransfusionView: View
    private lateinit var bloodDonationView: View
    private lateinit var signOutImage :ImageView
    private lateinit var moreImage:ImageView
    private lateinit var preferenceManager: PreferenceManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager = PreferenceManager(requireActivity())
        welcomeText = view.findViewById(R.id.welcome_text)
        clinicsView = view.findViewById(R.id.clinics)
        bloodDonationView = view.findViewById(R.id.blood_donation)
        bloodTransfusionView = view.findViewById(R.id.blood_transfusion)
        signOutImage = view.findViewById(R.id.imageSignOut)
        moreImage = view.findViewById(R.id.imageMore)
        setViewsData()
        setListeners()
    }
    private fun setViewsData(){
        val clinicsText = clinicsView.findViewById<TextView>(R.id.title)
        val bloodTransfusionText = bloodTransfusionView.findViewById<TextView>(R.id.title)
        val bloodDonationText = bloodDonationView.findViewById<TextView>(R.id.title)
        val clinicsImage = clinicsView.findViewById<ImageView>(R.id.thumbnail)
        val bloodTransfusionImage = bloodTransfusionView.findViewById<ImageView>(R.id.thumbnail)
        val bloodDonationImage = bloodDonationView.findViewById<ImageView>(R.id.thumbnail)
        clinicsText.text = getString(R.string.clinics)
        bloodDonationText.text = getString(R.string.blood_donation)
        bloodTransfusionText.text = getString(R.string.blood_transfusion)
        clinicsImage.setImageResource(R.drawable.clinics)
        bloodTransfusionImage.setImageResource(R.drawable.blood_transfusion)
        bloodDonationImage.setImageResource(R.drawable.blood_donation)
    }
    private fun setListeners(){
        signOutImage.setOnClickListener {
            preferenceManager.clear()
        }
        registerForContextMenu(moreImage)
        moreImage.setOnClickListener {view ->
            val popupMenu = PopupMenu(requireContext(),view)
            popupMenu.inflate(R.menu.language_menu)
            var currentLang = Locale.getDefault().language;
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.item_1 -> {

                        if (currentLang == "ar") {
                            changeLanguage("en", "English")
                        }else{
                            changeLanguage("ar", "Arabic")
                        }
                            true
                        }
                    else -> false

                }
                }
            popupMenu.show()
        }
    }


    private fun changeLanguage(language: String,name:String) {
        val locale = Locale(language)
        val resources: Resources = requireContext().resources
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        Locale.setDefault(locale)
        resources.configuration.updateFrom(config)
        Constants.showToast("Locale in $name !",requireContext())
        requireActivity().recreate()
    }

}