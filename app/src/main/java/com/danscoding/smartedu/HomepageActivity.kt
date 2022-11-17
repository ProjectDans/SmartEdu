package com.danscoding.smartedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danscoding.smartedu.LoginActivity.Companion.EXTRA_NAME
import com.danscoding.smartedu.databinding.ActivityHomepageBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.displayName.text = intent.getStringExtra(EXTRA_NAME)
        binding.btnLogout.setOnClickListener {
            Firebase.auth.signOut()

            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}