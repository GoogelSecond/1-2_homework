package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var replyHeadTextView: TextView
    private lateinit var replyTextView: TextView

    private lateinit var messageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        messageEditText = findViewById(R.id.editText_main)
        replyHeadTextView = findViewById(R.id.text_header_reply)
        replyTextView = findViewById(R.id.text_message_reply)
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val message = messageEditText.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY);
                replyHeadTextView.setVisibility(View.VISIBLE);
                replyTextView.setText(reply);
                replyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName

        const val EXTRA_MESSAGE = "com.example.helloworld.extra.MESSAGE"

        const val TEXT_REQUEST = 1
    }
}