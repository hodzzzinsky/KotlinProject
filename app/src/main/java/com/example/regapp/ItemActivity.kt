package com.example.regapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.razorpay.Checkout

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.item_title)
        val desc: TextView = findViewById(R.id.item_desc)


        title.text = intent.getStringExtra("itemTitle")
        desc.text = intent.getStringExtra("itemDesc")
    }
}