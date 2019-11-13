package com.example.sensoresacess


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sensor4.*

class sensor4G : AppCompatActivity(), SensorEventListener {


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }


    override fun onSensorChanged(event: SensorEvent?) {
        giro1.text = "x = ${event!!.values[0]}\n\n"
        giro2.text = "y = ${event.values[1]}\n\n"
        giro3.text = "z = ${event.values[2]}"
    }


    lateinit var manager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor4)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),SensorManager.SENSOR_DELAY_NORMAL)

    }
}
