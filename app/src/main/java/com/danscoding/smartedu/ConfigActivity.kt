package com.danscoding.smartedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.danscoding.smartedu.databinding.ActivityConfigBinding

class ConfigActivity : AppCompatActivity() {

    private lateinit var binding : ActivityConfigBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSelanjutnya.setOnClickListener {
            val intent = Intent(this@ConfigActivity, HomepageActivity::class.java)
            startActivity(intent)
        }
    }
}