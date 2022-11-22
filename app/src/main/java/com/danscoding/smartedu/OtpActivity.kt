package com.danscoding.smartedu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class OtpActivity : AppCompatActivity() {

    companion object {
        private const val TEST_VERIFY_CODE = "6768"
    }

    private val frameLayoutRoot: FrameLayout by lazy {
        findViewById(R.id.frameLayoutRoot)
    }

    private val editTextOne: EditText by lazy {
        findViewById(R.id.editTextOne)
    }

    private val editTextTwo: EditText by lazy {
        findViewById(R.id.editTextTwo)
    }

    private val editTextThree: EditText by lazy {
        findViewById(R.id.editTextThree)
    }

    private val editTextFour: EditText by lazy {
        findViewById(R.id.editTextFour)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()

        initFocus()
    }

    private fun setListener(){
        frameLayoutRoot.setOnClickListener {
            val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(frameLayoutRoot.windowToken,0)
        }

        setTextChangeListener(fromEditText = editTextOne, targetEditText = editTextTwo)
        setTextChangeListener(fromEditText = editTextTwo, targetEditText = editTextThree)
        setTextChangeListener(fromEditText = editTextThree, targetEditText = editTextFour)
        setTextChangeListener(fromEditText = editTextFour, done = {
            verifyOTPCode()
        })

        setKeyListener(fromEditText = editTextTwo, backToEditText = editTextOne)
        setKeyListener(fromEditText = editTextThree, backToEditText = editTextTwo)
        setKeyListener(fromEditText = editTextFour, backToEditText = editTextThree)
    }

    private fun initFocus(){
        editTextOne.isEnabled = true

        editTextOne.postDelayed({
            editTextOne.requestFocus()
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(editTextOne, InputMethodManager.SHOW_FORCED)
        },500)

    }

    private fun reset() {

        editTextOne.isEnabled = false
        editTextTwo.isEnabled = false
        editTextThree.isEnabled = false
        editTextFour.isEnabled = false

        editTextOne.setText("")
        editTextTwo.setText("")
        editTextThree.setText("")
        editTextFour.setText("")

        initFocus()

    }

    private fun setTextChangeListener(
        fromEditText: EditText,
        targetEditText: EditText? = null,
        done: (() -> Unit)? = null
    ) {

        fromEditText.addTextChangedListener {
            it?.let{ string ->
                if (string.isNotEmpty()) {

                    targetEditText?.let { editText ->

                        editText.isEnabled = true
                        editText.requestFocus()

                    } ?: run {
                        done ?.let {done->
                            done()
                        }
                    }

                    fromEditText.clearFocus()
                    fromEditText.isEnabled = false
                }
            }
        }
    }

    private fun setKeyListener(fromEditText: EditText, backToEditText: EditText ) {
        fromEditText.setOnKeyListener { _, _, event ->

            if (null != event && KeyEvent.KEYCODE_DEL == event.keyCode) {
                backToEditText.isEnabled = true
                backToEditText.requestFocus()
                backToEditText.setText("")

                fromEditText.clearFocus()
                fromEditText.isEnabled = false
            }

            false

        }
    }

    private fun verifyOTPCode() {
        val otpCode = "${editTextOne.text.toString().trim()}" +
                "${editTextTwo.text.toString().trim()}" +
                "${editTextThree.text.toString().trim()}" +
                "${editTextFour.text.toString().trim()}"

        if (4 != otpCode.length){
            return
        }

        if (otpCode == TEST_VERIFY_CODE) {

            Toast.makeText(this, "success, shoud do text", Toast.LENGTH_LONG).show()

            val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(frameLayoutRoot.windowToken,0)

            return
        }

        Toast.makeText(this, "error, input again", Toast.LENGTH_SHORT).show()
        reset()

    }
}