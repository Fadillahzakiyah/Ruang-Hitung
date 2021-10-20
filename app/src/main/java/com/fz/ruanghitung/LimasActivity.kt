package com.fz.ruanghitung

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LimasActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var panjang : EditText
    private lateinit var lebar : EditText
    private lateinit var tinggi : EditText
    private lateinit var btnHitung : Button
    private lateinit var hasil : TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_limas)

        panjang = findViewById(R.id.etPanjangLimas)
        lebar = findViewById(R.id.etLebarLimas)
        tinggi = findViewById(R.id.etTinggiLimas)
        btnHitung = findViewById(R.id.btnHitung)
        hasil = findViewById(R.id.tvHasil)

        btnHitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result =  savedInstanceState.getString(STATE_RESULT)
            hasil.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, hasil.text.toString())
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnHitung) {
            val inputPanjang = panjang.text.toString()
            val inputLebar = lebar.text.toString()
            val inputTinggi = tinggi.text.toString()

            var isEmptyField = false

            when {
                inputPanjang.isEmpty() -> {
                    isEmptyField = true
                    panjang.error = "Field panjang tidak boleh kosong"
                }
                inputLebar.isEmpty() -> {
                    isEmptyField = true
                    lebar.error = "Field lebar tidak boleh kosong"
                }
                inputTinggi.isEmpty() -> {
                    isEmptyField = true
                    tinggi.error = "Field tinggi tidak boleh kosong"
                }
            }
            if (!isEmptyField) {
                val volume = ((inputPanjang.toInt() * inputLebar.toInt())*inputTinggi.toInt())/3
                hasil.text = "Volume limas adalah " + volume.toString() + "cm^3"
            }
        }
    }
}