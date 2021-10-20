package com.fz.ruanghitung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonKerucut : Button = findViewById(R.id.btnKerucut)
        buttonKerucut.setOnClickListener{
            var intent = Intent(this@MainActivity, KerucutActivity::class.java)
            startActivity(intent)
        }

        val buttonLimas: Button = findViewById(R.id.btnLimas)
        buttonLimas.setOnClickListener{
            var intent = Intent(this@MainActivity, LimasActivity::class.java)
            startActivity(intent)
        }

        val buttonBola: Button = findViewById(R.id.btnBola)
        buttonBola.setOnClickListener{
            var intent = Intent(this@MainActivity, BolaActivity::class.java)
            startActivity(intent)
        }

    }
}