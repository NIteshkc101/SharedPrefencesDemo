package com.example.sharedpreferencesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.sharedpreferencesapp.utils.SharedPreferenceUtil

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var userNameTextField : TextView
    private lateinit var logoutButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userNameTextField = findViewById(R.id.userNameResult)
        logoutButton = findViewById(R.id.logoutButton)


        val userName = SharedPreferenceUtil.getUserName(this)

        userNameTextField.text ="Hola $userName"

        logoutButton.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        SharedPreferenceUtil.clearAll(this)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}