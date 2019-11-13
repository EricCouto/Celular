package com.example.sensoresacess

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sensor1.*

class sensor1L : AppCompatActivity(), SensorEventListener {

    lateinit var manager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor1)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


        manager.registerListener(
            this,
            manager.getDefaultSensor(Sensor.TYPE_LIGHT),
            SensorManager.SENSOR_DELAY_NORMAL
        )

        BackAcel.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


    override fun onSensorChanged(event: SensorEvent?) {
        var valor = event!!.values[0]

        luz.text =("Luminosidade "+ valor)
    }

    override fun onResume() {
        super.onResume()
        manager!!.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        manager!!.unregisterListener(this)
    }
}
