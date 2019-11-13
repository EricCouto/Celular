package com.example.sensoresacess

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sensor3.*

class sensor3A : AppCompatActivity(), SensorEventListener {

    lateinit var manager: SensorManager


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}


    override fun onSensorChanged(event: SensorEvent?) {
        acel1.text = "x = ${event!!.values[0]}\n\n"
        acel2.text = "y = ${event.values[1]}\n\n"
        acel3.text = "z = ${event.values[2]}"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor3)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL)

        BackAcel.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
