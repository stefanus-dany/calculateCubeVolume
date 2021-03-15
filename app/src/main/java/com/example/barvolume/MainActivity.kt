package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.fieldLebar)
        edtHeight = findViewById(R.id.fieldTinggi)
        edtLength = findViewById(R.id.fieldPanjang)
        btnCalculate = findViewById(R.id.hitung)
        tvResult = findViewById(R.id.tvHasil)

        btnCalculate.setOnClickListener {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var empty = false
            when {
                inputLength.isEmpty()->{
                    empty = true
                    edtLength.error = "Field ini tidak boleh kosong"
                }

                inputWidth.isEmpty()->{
                    empty = true
                    edtWidth.error = "Field ini tidak boleh kosong"
                }

                inputHeight.isEmpty()->{
                    empty = true
                    edtHeight.error = "Field ini tidak boleh kosong"
                }


            }
            if (!empty){
                var volume = inputHeight.toDouble() * inputWidth.toDouble() * inputLength.toDouble()
                tvResult.text = volume.toString()
            }
        }

        if (savedInstanceState!=null){
            val hasil = savedInstanceState.getString("string")
            tvResult.text = hasil
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("string", tvResult.text.toString())
    }


}