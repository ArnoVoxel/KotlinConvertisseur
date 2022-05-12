package com.example.convertkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spinnerDepart = findViewById<Spinner>(R.id.spinnerDepart)
        var spinnerArrivee = findViewById<Spinner>(R.id.spinnerArrivee)

        var btn = findViewById<Button>(R.id.convertir)
        btn.setOnClickListener(
            View.OnClickListener() {
                var deviseDepart = spinnerDepart.selectedItem.toString()
                var deviseArrivee = spinnerArrivee.selectedItem.toString()
                var montant_convert = findViewById<EditText>(R.id.montant).text.toString()

                if (deviseDepart.equals("")){
                    Toast.makeText(this,R.string.erreur_devise_depart, Toast.LENGTH_SHORT).show()
                } else if (deviseArrivee.equals("")){
                    Toast.makeText(this,R.string.erreur_devise_arrivee, Toast.LENGTH_SHORT).show()
                } else if (deviseDepart.equals(deviseArrivee)){
                    Toast.makeText(this,R.string.erreur_devise_identique, Toast.LENGTH_SHORT).show()
                } else if (montant_convert.equals("")||montant_convert.equals(".")){
                    Toast.makeText(this,R.string.erreur_montant, Toast.LENGTH_SHORT).show()
                } else {
                    var montant = montant_convert.toDouble()
                    var result = try {
                        Convert.convertir(deviseDepart, deviseArrivee, montant)
                    } catch (e: Exception) {
                        Toast.makeText(this,R.string.erreur_montant, Toast.LENGTH_SHORT).show()
                    }
                    Toast.makeText(this,"le montant à convertir est "+result, Toast.LENGTH_SHORT).show()

                }

                //Toast.makeText(this,"toast Kotlin", Toast.LENGTH_SHORT).show()
            }
        )

    }
}

