package com.example.nexus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val signupText = findViewById<TextView>(R.id.tvGoToSignup)
        signupText.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        // Assuming you have a button to continue with mobile login:
        val btnContinueLogin = findViewById<Button>(R.id.btnContinue) // Replace with actual button id
        btnContinueLogin.setOnClickListener {
            // Navigate to OTP verification with an extra to specify login
            val intent = Intent(this, OtpVerificationActivity::class.java)
            intent.putExtra("user_flow", "login")
            startActivity(intent)
        }
    }
}
