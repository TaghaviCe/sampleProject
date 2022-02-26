package com.example.sampleproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sampleproject.databinding.ActivityConsultBinding

class ConsultActivity : AppCompatActivity() {
    lateinit var binding1 : ActivityConsultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consult)
        binding1 = ActivityConsultBinding.inflate(layoutInflater)
        val view = binding1.root
        setContentView(view)
        initViews()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("textView1Text" , binding1.textView.text.toString())
        super.onSaveInstanceState(outState)
    }

    private fun initViews() {
        var id = intent.getIntExtra("id" , -1)
        if (id == -1){
            binding1.textView.text = "ٔدکتر شما پیدا نشد"
        }else {
            var myDoctor = Hospital.getDoctor(id)
            binding1.textView.text = "دکتر ${myDoctor?.name} با شما تماس خواهد گرفت"
        }
        binding1.button4.setOnClickListener {
            var username = binding1.editTextTextPersonName.text.toString()
            var userTel = binding1.editTextTextPersonName2.text.toString()
            saveInShared(username , userTel)
            openCheckActivity()
        }


    }
    private fun saveInShared(username: String, userTel: String) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name" , username)
        editor.putString("tel" , userTel)
        editor.apply()
    }
    private fun openCheckActivity() {
        val intent = Intent(this , UserCheck::class.java)
        startForResult.launch(intent)
    }
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val isOk =  intent?.getBooleanExtra("isOk", false)
            Toast.makeText(this ,"isOk value is : " + isOk , Toast.LENGTH_SHORT).show()
            isOk?.let{
                if(it)
                    Toast.makeText(this , "الان دکتر بهت زنگ می زنه" , Toast.LENGTH_SHORT).show()

            }
        }
    }
}