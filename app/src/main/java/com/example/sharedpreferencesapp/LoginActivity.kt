package com.example.sharedpreferencesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sharedpreferencesapp.utils.Constants
import com.example.sharedpreferencesapp.utils.FileFunctions
import com.example.sharedpreferencesapp.utils.SharedPreferenceUtil

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var loginButton : Button
    private lateinit var userNameText: EditText
    private lateinit var passwordText: EditText
    private lateinit var fullNameText: EditText
    private lateinit var resultNameText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton= findViewById(R.id.button)
        userNameText =findViewById(R.id.editTextUsername)
        fullNameText =findViewById(R.id.editTextFullName)
        passwordText =findViewById(R.id.editTextTextPassword)
        resultNameText =findViewById(R.id.resultName)
        loginButton.setOnClickListener(this)



    }

    override fun onClick(view: View?) {

        if(view == loginButton){

            val userName = userNameText.text.toString().trim()
            val fullName = fullNameText.text.toString().trim()
            val password = passwordText.text.toString().trim()

            FileFunctions.appendFileValue(
                Constants.LOG_FILE_NAME,
                userName,
                this
            )


            SharedPreferenceUtil.saveUserName(this, userName)
            SharedPreferenceUtil.saveFullName(this, fullName)
            SharedPreferenceUtil.savePassword(this, password)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()


        }




    }

}
