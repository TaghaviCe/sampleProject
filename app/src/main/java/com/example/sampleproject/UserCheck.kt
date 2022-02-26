package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.databinding.ActivityUserCheckBinding

class UserCheck : AppCompatActivity() {
    lateinit var binding3:ActivityUserCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_check)
        binding3 = ActivityUserCheckBinding.inflate(layoutInflater)
        val view = binding3.root
        setContentView(view)
        intentview()
    }

    private fun intentview() {
        binding3.button2.setOnClickListener {
            val yes=binding3.checkBox.isChecked
            returnResult(yes)
        }
    }

    private fun returnResult(yes: Boolean) {
        val result= Intent()
        result.putExtra("yes",yes)
        setResult(RESULT_OK,result)
        finish()
    }
}