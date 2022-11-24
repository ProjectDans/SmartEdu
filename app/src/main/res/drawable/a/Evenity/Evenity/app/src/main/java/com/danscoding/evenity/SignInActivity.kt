package com.danscoding.evenity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.danscoding.evenity.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSignIn.setOnClickListener { intentToHome() }
        binding.buttonRegister.setOnClickListener { intentToRegister() }
        //CUSTOMVIEW PASSWORD
        binding.passwordEditText.doOnTextChanged { text, _, _, _ ->
            if (text!!.length < 6) {
                binding.passwordEditTextLayout.error = "minimal password 6 huruf"
            } else {
                binding.passwordEditTextLayout.error = null
            }
        }
    }

//    private fun showLoading(isLoading : Boolean) {
//        if (isLoading) {
//            binding.progressBar.visibility = View.VISIBLE
//        } else {
//            binding.progressBar.visibility = View.GONE
//        }
//    }

    private fun intentToHome() {
        val intent = Intent(this@SignInActivity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun intentToRegister() {
        val intent = Intent(this@SignInActivity, RegisterActivity::class.java)
        startActivity(intent)
    }
}