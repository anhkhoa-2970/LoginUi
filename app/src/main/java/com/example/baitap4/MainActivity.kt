package com.example.baitap4

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.baitap4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var emailId = binding.edtMail
        binding.btnLogin.setOnClickListener {
            if (emailId.text.toString().isEmpty()) {
                Toast.makeText(applicationContext, "enter email address", Toast.LENGTH_SHORT).show()
            } else {
                if (emailId.text.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())) {
                    Toast.makeText(applicationContext, "valid email address", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        binding.edtMail.doOnTextChanged { text, start, before, count ->
            if (emailId.text.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())) {
                emailId.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_person,
                    0,
                    R.drawable.imagecheck,
                    0
                )
            }
        }

        binding.tvSignUp.setOnClickListener {
            Toast.makeText(this, "You click on sign up", Toast.LENGTH_SHORT).show()
        }

        binding.btnFacebook.setOnClickListener {
            val uri = "https://www.facebook.com/"
            browser(uri)
        }
        binding.btnTwitter.setOnClickListener {
            val uri = "https://twitter.com/?lang=vi"
            browser(uri)
        }
        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "You click on Forgot password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun browser(uri: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(uri)
        startActivity(intent)
    }
}