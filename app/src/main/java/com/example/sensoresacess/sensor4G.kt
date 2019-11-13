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
import kotlinx.android.synthetic.main.activity_sensor4.*

class sensor4G : AppCompatActivity(), SensorEventListener {
    lateinit var manager: SensorManager

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        giro1.text = "Z = ${event!!.values[0]}\n\n"
        giro2.text = "X = ${event.values[1]}\n\n"
        giro3.text = "Y = ${event.values[2]}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor4)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),SensorManager.SENSOR_DELAY_NORMAL)

        BackGiro.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
