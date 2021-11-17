package com.example.sharedpreferencesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.sharedpreferencesapp.utils.Constants
import com.example.sharedpreferencesapp.utils.FileFunctions
import com.example.sharedpreferencesapp.utils.SharedPreferenceUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var userNameTextField : TextView
    private lateinit var logoutButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userNameTextField = findViewById(R.id.userNameResult)
        logoutButton = findViewById(R.id.logoutButton)


        val userName = SharedPreferenceUtil.getUserName(this)

        userNameTextField.text ="Hola,  $userName"

        val userNameFromFile = FileFunctions.getFileValue(Constants.LOG_FILE_NAME,this).toString()

        userNameResultFile.text =userNameFromFile

        logoutButton.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        SharedPreferenceUtil.clearAll(this)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}