package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initText()
    }

    private fun initText() {
        Hospital.setTestDate()
        var myDoctor = Hospital.doctor[0]
        binding.textViewname.text = myDoctor.name
        binding.textViewstatus.text = myDoctor.Type.toString()
        var doctor = Hospital.conf[0]
        binding.text10.text = " مشاوره تلفنی " + doctor.time + " دقیقه ای "
        binding.textViewprice.text = doctor.price.toString() + " تومان "
        binding.confere.setOnClickListener {
            Toast.makeText(this, "cunsultancy is chosen", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ConsultActivity::class.java)
            intent.putExtra("id", myDoctor.id)
            startActivity(intent)
        }
    }
}