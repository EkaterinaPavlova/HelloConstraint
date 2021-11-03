package com.hfad.helloconstraint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import helloconstraint.R

class MainActivity : AppCompatActivity() {

    private var mCount = 0
    private lateinit var mShowCount: TextView
    private lateinit var buttonZero: Button
    private lateinit var buttonCount: Button

    companion object {
        private const val KEY_COUNT = "KEY_COUNT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)
        buttonZero = findViewById(R.id.button_zero)
        buttonCount = findViewById(R.id.button_count)

        checkCount(mCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mCount = savedInstanceState.getInt(KEY_COUNT)
        mShowCount.text = mCount.toString()
        checkCount(mCount)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, mCount)
    }


    fun showToast(view: android.view.View) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun countUp(view: android.view.View) {
        mCount ++
        mShowCount.text = mCount.toString()
        checkCount(mCount)
    }

    fun returnZero(view: android.view.View) {
        mCount = 0
        mShowCount.text = mCount.toString()
        checkCount(mCount)
    }

    private fun checkCount (mCount: Int){
        when {
            mCount == 0 -> {
                buttonZero.setBackgroundColor(Color.GRAY)
                buttonCount.setBackgroundColor(Color.BLUE)
            }
            mCount %2 == 0 -> {
                buttonCount.setBackgroundColor(Color.BLUE)
                buttonZero.setBackgroundColor(Color.MAGENTA)
            }
            else -> {
                buttonCount.setBackgroundColor(Color.GREEN)
                buttonZero.setBackgroundColor(Color.MAGENTA)
            }
        }
    }
}