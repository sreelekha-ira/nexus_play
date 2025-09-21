package com.example.nexus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OtpVerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp)

        val userFlow = intent.getStringExtra("user_flow") ?: "login" // default to login

        val btnVerifyOtp = findViewById<Button>(R.id.btnVerifyOtp)
        btnVerifyOtp.setOnClickListener {
            // Here, add your OTP verification logic

            val nextIntent = when (userFlow) {
                "signup" -> Intent(this, CreateProfileActivity::class.java)
                "login" -> Intent(this, HomeActivity::class.java)
                else -> Intent(this, MainActivity::class.java)
            }
            startActivity(nextIntent)
            finish()
        }
    }
}
