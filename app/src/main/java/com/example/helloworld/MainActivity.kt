package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "Hello World");
        textView = findViewById(R.id.show_count)
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

    fun countUp(view: View) {
        mCount++
        if (mCount != 0) {
            textView.text = mCount.toString()
        }
    }
}