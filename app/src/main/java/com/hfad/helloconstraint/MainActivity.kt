package com.hfad.helloconstraint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import helloconstraint.R
import helloconstraint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mCount = 0
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val KEY_COUNT = "KEY_COUNT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        checkCount(mCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mCount = savedInstanceState.getInt(KEY_COUNT)
        binding.showCount.text = mCount.toString()
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
        mCount++
        binding.showCount.text = mCount.toString()
        checkCount(mCount)
    }

    fun returnZero(view: android.view.View) {
        mCount = 0
        binding.showCount.text = mCount.toString()
        checkCount(mCount)
    }

    private fun checkCount(mCount: Int) {
        when {
            mCount == 0 -> {
                binding.buttonCount.setBackgroundColor(Color.BLUE)
                binding.buttonZero.setBackgroundColor(Color.GRAY)
            }
            mCount % 2 == 0 -> {
                binding.buttonCount.setBackgroundColor(Color.BLUE)
                binding.buttonZero.setBackgroundColor(Color.MAGENTA)
            }
            else -> {
                binding.buttonCount.setBackgroundColor(Color.GREEN)
                binding.buttonZero.setBackgroundColor(Color.MAGENTA)
            }
        }
    }
}