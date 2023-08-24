package com.example.first_android_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View
import com.example.first_android_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contactButton.setOnClickListener {
            val recipientEmail = "fernando.takashi12@gmail.com"

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$recipientEmail")
            }

            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }

    fun openUrl(view: View) {
        val url = when (view.id) {
            R.id.github -> "https://www.github.com/TakashiGianz"
            R.id.linkedin -> "https://www.linkedin.com/in/fernando-gianzanti/"
            R.id.instagram -> "https://www.instagram.com/_gianzanti/"
            else -> "https://www.androidstudio.com"
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}



