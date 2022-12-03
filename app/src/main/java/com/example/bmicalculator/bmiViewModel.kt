package com.example.bmicalculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    var result = MutableLiveData<String>()
    var bmiInfo = MutableLiveData<String>()
    var bmiMsg = MutableLiveData<String>()

    init {
        result.value = ""
        bmiInfo.value = ""
        bmiMsg.value = ""
    }

    fun calculate(height: Int, weight: Int) {

        val heightInMeter = height.toFloat() / 100
        println("Height in meter:" + heightInMeter)
        val value: Float = weight / (heightInMeter * heightInMeter)

        bmiInfo.value = value.toString().substring(0, 4)

        if (value < 18.5 && value > 0) {
            result.value = "Underweight"
            bmiMsg.value = "You are Underweight \nEast well!"
        } else if (value >= 18.5 && value <= 22.9) {
            result.value = "Normal"
            bmiMsg.value = "You have a \nNormal body weight!"
        } else if (value >= 23 && value <= 24.9) {
            result.value = "Risk to overweight"
            bmiMsg.value = "You are \nRisk to overweight!"
        } else if (value >= 25 && value <= 29.9) {
            result.value = "Overweight"
            bmiMsg.value = "You have a \nOverweight Body!"
        } else if (value > 30) {
            result.value = "Obese"
            bmiMsg.value = "You have a \nObese body weight!"
        } else {
            result.value = "Invalid"
            bmiMsg.value = "Invalid Result"
        }
        println("MyLog:" + result.value)
        println("MyValue" + value)
    }
}