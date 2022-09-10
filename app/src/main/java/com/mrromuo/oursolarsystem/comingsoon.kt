package com.mrromuo.oursolarsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

var tv:TextView? = null

class comingsoon : AppCompatActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_comingsoon)
            tv = findViewById(R.id.comingsoonTV)
            tv?.setOnClickListener(){
                 val intent = Intent(this,MainActivity::class.java)
                 startActivity(intent)
            }

      }

      fun back(view: View) {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
      }
}