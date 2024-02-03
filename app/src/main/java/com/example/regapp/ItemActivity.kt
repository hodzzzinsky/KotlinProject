package com.example.regapp

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.item_title)
        val desc: TextView = findViewById(R.id.item_desc)
        val button: Button = findViewById(R.id.item_button)
        val img: ImageView = findViewById(R.id.inner_img)

        button.setOnClickListener {
            val intent =  Intent(this, ItemsActivity::class.java)
            startActivity(intent)
        }


        title.text = intent.getStringExtra("itemTitle")
        desc.text = intent.getStringExtra("itemDesc")
        img.setImageResource(intent.getStringExtra("inner_img")!!.toInt())

    }
}