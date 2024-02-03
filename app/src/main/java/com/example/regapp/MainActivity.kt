package com.example.regapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.regapp.R.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val userLogin : EditText = findViewById(id.userLogin)
        val userEmail : EditText = findViewById(id.userEmail)
        val userPassword : EditText = findViewById(id.userPassword)
        val button : Button = findViewById(id.buttonReg)
        val backLogIn: TextView = findViewById(id.back_logIn)

        backLogIn.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()
            if (login == "" || email == "" || password == "") Toast.makeText(this, "fields shouldn't be empty", Toast.LENGTH_SHORT).show()
            else {
                val user = User(login, email, password)
                val db = DB(this, null)
                db.addUser(user)
                Toast.makeText(this, "user $login added", Toast.LENGTH_SHORT).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }



        }

    }
}