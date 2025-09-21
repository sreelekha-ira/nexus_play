package com.example.nexus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        val LoginText = findViewById<TextView>(R.id.tvGoToLogin)
        LoginText.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val btnContinueSignup = findViewById<Button>(R.id.btnContinueSignup)
        btnContinueSignup.setOnClickListener {
            // Navigate to OTP verification with an extra to specify signup
            val intent = Intent(this, OtpVerificationActivity::class.java)
            intent.putExtra("user_flow", "signup")
            startActivity(intent)
        }
    }
}
