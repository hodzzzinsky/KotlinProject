package com.example.regapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.regapp.R.*


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val userLogin: EditText = findViewById(id.userLogin)
        val userEmail: EditText = findViewById(id.userEmail)
        val userPassword: EditText = findViewById(id.userPassword)
        val button: Button = findViewById(id.buttonReg)
        val backLogIn: TextView = findViewById(id.back_logIn)

        backLogIn.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()
            if (login == "" || email == "" || password == "") Toast.makeText(
                this,
                "fields shouldn't be empty",
                Toast.LENGTH_SHORT
            ).show()
            else {
                if (checkValidCredentials(login, email, password)) {
                    val db = DB(this, null)
                    if (!db.ifExists(login)) {
                        val user = User(login, email, password)
                        db.addUser(user)

                        Toast.makeText(this, "user $login added", Toast.LENGTH_SHORT).show()
                        userLogin.text.clear()
                        userEmail.text.clear()
                        userPassword.text.clear()

                        val intent = Intent(this, ItemsActivity::class.java)
                        startActivity(intent)

                    } else Toast.makeText(this, "user $login already exists", Toast.LENGTH_SHORT)
                        .show()
                }
            }


        }

    }

    private fun checkValidCredentials(login: String, email: String, password: String): Boolean {
        if (!isValidPasswordOrLogin(login)) {
            Toast.makeText(this, "login is not valid", Toast.LENGTH_SHORT).show(); return false
        }
        if (!isValidEmail(email)) {
            Toast.makeText(this, "email is not valid", Toast.LENGTH_SHORT).show(); return false
        }
        if (!isValidPasswordOrLogin(password)) {
            Toast.makeText(this, "password is too short", Toast.LENGTH_SHORT).show(); return false
        }
        return true
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target)
            .matches();
    }

    private fun isValidPasswordOrLogin(target: CharSequence?): Boolean {
        return target!!.isNotEmpty() && target.length >= 4
    }
}
