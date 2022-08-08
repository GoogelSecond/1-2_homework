package com.example.helloworld

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat


class MainActivity : AppCompatActivity() {

    private lateinit var webSiteEditText: EditText
    private lateinit var locationEditText: EditText
    private lateinit var shareTextEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webSiteEditText = findViewById(R.id.website_edittext)
        locationEditText = findViewById(R.id.location_edittext)
        shareTextEditText = findViewById(R.id.share_edittext)
    }

    fun openWebsite(view: View) {
        val url = webSiteEditText.text.toString()
        val webPage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun openLocation(view: View) {
        val loc = locationEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=" + loc)
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun shareText(view: View) {
        val txt = shareTextEditText.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share this text with: ")
            .setText(txt)
            .startChooser()
    }
}