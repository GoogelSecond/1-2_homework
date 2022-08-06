package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private lateinit var textView: TextView
    private lateinit var zeroButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "Hello World");
        textView = findViewById(R.id.show_count)
        zeroButton = findViewById(R.id.button_zero)
    }

    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName
    }

    fun showToast(view: View) {
        val toast: Toast = Toast.makeText(
            this, R.string.toast_message,
            Toast.LENGTH_SHORT
        )
        toast.show()

    }

    fun countUp(button: View) {
        mCount++

        if (mCount % 2 ==0) {
            val evenColor = ContextCompat.getColor(this, android.R.color.holo_green_dark)
            button.setBackgroundColor(evenColor)
        } else {
            val oddColor = ContextCompat.getColor(this, android.R.color.holo_blue_dark)
            button.setBackgroundColor(oddColor)
        }
        if (mCount != 0) {
            textView.text = mCount.toString()
            val changedZeroColor = ContextCompat.getColor(this, android.R.color.holo_purple)
            zeroButton.setBackgroundColor(changedZeroColor)
        }
    }

    fun setZeroCount(button: View) {
        val greyColor = ContextCompat.getColor(this, android.R.color.darker_gray)
        button.setBackgroundColor(greyColor)
        mCount = 0
        textView.text = mCount.toString()
    }
}