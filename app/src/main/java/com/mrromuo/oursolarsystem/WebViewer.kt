package com.mrromuo.oursolarsystem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class WebViewer : AppCompatActivity() {
      lateinit var webViewTitle: TextView
      lateinit var webViewWeb: WebView
      lateinit var weblayout: LinearLayout
      @SuppressLint("SetJavaScriptEnabled")
      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_web_viewer)
            webViewTitle = findViewById(R.id.webViewText)
            weblayout = findViewById(R.id.webViewLayout)
            webViewWeb = findViewById(R.id.webViewWeb)
            webViewTitle.text = getText(R.string.aboutme)
            val website = "https://mrromuo.com/about-us"
            webViewWeb.settings.javaScriptEnabled = true
            webViewWeb.settings.setSupportZoom(true)
            webViewWeb.loadUrl(website)
      }
}