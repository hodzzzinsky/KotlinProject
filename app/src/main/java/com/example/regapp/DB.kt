package com.example.regapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB(private val context: Context, factory: SQLiteDatabase.CursorFactory?)
    : SQLiteOpenHelper(context, "app", factory, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "Create table users " +
                "(" +
                "id INT PRIMARY KEY, " +
                "login TEXT," +
                "email TEXT," +
                "password TEXT" +
                ")"
        db!!.execSQL(query) //!!. обработка NULL узнать побольше

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }


    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("password", user.password)
        val db = this.writableDatabase
        db.insert("users", null, values)
        db.close()
    }

    fun getUser(login: String, password: String) : Boolean {
        val db = this.readableDatabase

        val result = db.rawQuery("SELECT * FROM users u WHERE u.login = '$login' and u.password = '$password'", null)
        return result.moveToFirst()
    }
}