package com.example.sensoresacess

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sensor2.*


class sensor2P : AppCompatActivity(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {

        var valor = event!!.values[0]


        Prox.text = ("proximidade " + valor)


    }

    lateinit var manager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor2)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


        manager.registerListener(this,manager.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_FASTEST)


    }
}

