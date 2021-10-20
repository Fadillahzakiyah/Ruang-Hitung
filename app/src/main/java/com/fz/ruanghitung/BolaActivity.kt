package com.fz.ruanghitung

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BolaActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var jari_jari : EditText
    private lateinit var btnHitung : Button
    private lateinit var hasil : TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bola)

        jari_jari = findViewById(R.id.etJariBola)
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
            val inputJariJari = jari_jari.text.toString()

            var isEmptyField = false

            when {
                inputJariJari.isEmpty() ->  {
                    isEmptyField = true
                    jari_jari.error = "Field jari-jari tidak boleh kosong"
                }
            }
            if (!isEmptyField) {
                val phi = 3.14
                val volume = (4*phi*(inputJariJari.toInt()*inputJariJari.toInt()*inputJariJari.toInt()))/3
                hasil.text = "Volume bola adalah " + volume.toInt() + "cm^3"
            }
        }
    }
}