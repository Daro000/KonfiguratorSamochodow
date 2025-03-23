package com.example.konfiguratorsamochodu

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val carImage = findViewById<ImageView>(R.id.carImage)
        val klimatyzacjaCheckBox = findViewById<CheckBox>(R.id.klimatyzacja)
        val skorzaneCheckBox = findViewById<CheckBox>(R.id.skorzane_siedzenia)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val summaryTextView = findViewById<TextView>(R.id.summary)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.sedan -> carImage.setImageResource(R.drawable.sedan)
                R.id.suv -> carImage.setImageResource(R.drawable.suv)
                R.id.hatchback -> carImage.setImageResource(R.drawable.hatchback)
            }
        }

        submitButton.setOnClickListener {
            val selectedModel = when (radioGroup.checkedRadioButtonId) {
                R.id.sedan -> "Sedan"
                R.id.suv -> "SUV"
                R.id.hatchback -> "Hatchback"
                else -> "Brak modelu"
            }

            val klimatyzacja = if (klimatyzacjaCheckBox.isChecked) "Klimatyzacja" else "Brak klimatyzacji"
            val skorzaneSiedzenia = if (skorzaneCheckBox.isChecked) "Skórzane siedzenia" else "Brak skórzanych siedzeń"
            val summary = "Model: $selectedModel\nOpcje: $klimatyzacja, $skorzaneSiedzenia"
            summaryTextView.text = summary
        }

        }
}