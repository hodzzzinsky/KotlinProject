package com.example.regapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.regapp.R.id.backCreate

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val linkToReg: TextView = findViewById(backCreate)
        val userLogin : EditText = findViewById(R.id.userLoginAuth)
        val userPassword : EditText = findViewById(R.id.userPasswordAuth)
        val button : Button = findViewById(R.id.ButtonAuth)

        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()
            if (login == "" || password == "") Toast.makeText(this, "Epty filed(s)", Toast.LENGTH_SHORT).show()
            else {

                val db = DB(this, null)
                val isAuth = db.getUser(login, password)


                if (isAuth) {
                    Toast.makeText(this, "You logged with $login", Toast.LENGTH_SHORT).show()
                    userLogin.text.clear()
                    userPassword.text.clear()
                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                } else Toast.makeText(this, "incorrect login or password", Toast.LENGTH_SHORT).show()
            }



        }
    }
}