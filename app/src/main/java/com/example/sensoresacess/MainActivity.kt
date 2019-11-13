package com.example.sensoresacess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoLuz.setOnClickListener {
            startActivity(Intent(this,sensor1L::class.java))
        }

        botaoProxi.setOnClickListener {
            startActivity(Intent(this,sensor2P::class.java))
        }

        botaoAcele.setOnClickListener {
            startActivity(Intent(this,sensor3A::class.java))
        }

        botaoGiro.setOnClickListener {
            startActivity(Intent(this,sensor4G::class.java))
        }

    }
}
