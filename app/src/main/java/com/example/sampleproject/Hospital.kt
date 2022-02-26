package com.example.sampleproject

object Hospital {
    val doctor= arrayListOf<Doctor>()
   val conf= arrayListOf<conference>(
       conference(1,30,100000),
       conference(2,60,250000),
       conference(3,90,144000)
   )
    fun setTestDate(){
        doctor.clear()
        doctor.add(
            Doctor("omid",1,status.Offline)
        )
        doctor.add(
            Doctor("Amir",2,status.Online)
        )
        doctor.add(
            Doctor("Zahra",3,status.Online)
        )
    }
    fun getDoctor(id : Int) : Doctor?{
        for (doctor in doctor){
            if (doctor.id == id){
                return doctor
            }
        }
        return null
    }
}