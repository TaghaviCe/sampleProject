package com.example.sampleproject

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val doctorList = Hospital.doctor
    val consultancyList = Hospital.conf
}