package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val button = findViewById<Button>(R.id.button)
        val editTextTextEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword2 = findViewById<EditText>(R.id.editTextTextPassword2)

        button.setOnClickListener {
            if(editTextTextEmailAddress.text.isNullOrBlank() || editTextTextPassword2.text.isNullOrBlank()){
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }else{
                val username = editTextTextEmailAddress.text.toString()
                val intent = Intent(this, Login::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }
        }

    }
}