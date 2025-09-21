package com.example.nexus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.imageview.ShapeableImageView

class CreateProfileActivity : AppCompatActivity() {

    private lateinit var imgProfile: ShapeableImageView
    private lateinit var btnUploadPhoto: Button
    private lateinit var etName: TextInputEditText
    private lateinit var etGamerTag: TextInputEditText
    private lateinit var etLocation: TextInputEditText
    private lateinit var btnFinishSignup: Button

    // Register for photo pick result
    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            imgProfile.setImageURI(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)  // Your XML layout filename here

        // Initialize Views
        imgProfile = findViewById(R.id.imgProfile)
        btnUploadPhoto = findViewById(R.id.btnUploadPhoto)
        etName = findViewById(R.id.etName)
        etGamerTag = findViewById(R.id.etGamerTag)
        etLocation = findViewById(R.id.etLocation)
        btnFinishSignup = findViewById(R.id.btnFinishSignup)

        // Upload photo button click opens gallery picker
        btnUploadPhoto.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        // Finish button click - validate and proceed
        btnFinishSignup.setOnClickListener {
            val name = etName.text.toString().trim()
            val gamerTag = etGamerTag.text.toString().trim()
            val location = etLocation.text.toString().trim()

            if (name.isEmpty()) {
                etName.error = "Name is required"
                etName.requestFocus()
                return@setOnClickListener
            }

            if (gamerTag.isEmpty()) {
                etGamerTag.error = "Gamer Tag is required"
                etGamerTag.requestFocus()
                return@setOnClickListener
            }

            if (location.isEmpty()) {
                etLocation.error = "Location is required"
                etLocation.requestFocus()
                return@setOnClickListener
            }

            // TODO: Save profile info to database or preferences here

            Toast.makeText(this, "Profile created successfully", Toast.LENGTH_SHORT).show()

            // Proceed to main/home activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
