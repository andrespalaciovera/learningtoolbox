package com.example.learningtoolbox.view.ui.activities

import android.content.Intent
import com.firebase.ui.auth.AuthUI
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningtoolbox.R
import com.example.learningtoolbox.databinding.ActivityLoginBinding
import com.example.learningtoolbox.view.ui.activities.MainActivity as MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val AUTH_REQUEST_CODE = 1234
    lateinit var firebaseAuth: FirebaseAuth
    private lateinit var listener: FirebaseAuth.AuthStateListener
    lateinit var providers: List<AuthUI.IdpConfig>
    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener(listener)
    }
    override fun onStop() {
        if (listener != null)
            firebaseAuth.removeAuthStateListener(listener)
        super.onStop()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()
        )
        val intent = Intent(this,MainActivity::class.java)
        firebaseAuth = FirebaseAuth.getInstance()
        listener = FirebaseAuth.AuthStateListener { p0 ->
            val user = p0.currentUser
            if (user != null) {
                startActivity(intent)
            } else {
                startActivityForResult(
                    AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)

                        .setLogo(R.drawable.logo)
                        .setTheme(R.style.LoginTheme)
                        .build(), AUTH_REQUEST_CODE
                )
            }
        }
    }
}