package com.example.nexus

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logoImage)

        // Start with logo invisible & small
        logo.alpha = 0f
        logo.scaleX = 0.8f
        logo.scaleY = 0.8f

        // Animate logo
        logo.animate()
            .alpha(1f)              // fade in
            .scaleX(1.2f)           // scale up a little
            .scaleY(1.2f)
            .setDuration(2000)      // animation lasts 2s
            .withEndAction {
                // After animation, go to LoginActivity
                startActivity(Intent(this, LoginActivity::class.java))
                finish() // prevent going back to splash
            }
    }
}
