package com.mrromuo.oursolarsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.webkit.WebView
import android.widget.*
import com.mrromuo.oursolarsystem.MainActivity.Companion.KEY_POSITION
import com.mrromuo.oursolarsystem.MainActivity.Companion.loacallang
import com.mrromuo.oursolarsystem.MainActivity.Companion.planImagId
import com.mrromuo.oursolarsystem.MainActivity.Companion.planetslist
import com.mrromuo.oursolarsystem.data.SolarSystemPlanets

class PlanetViewr : AppCompatActivity(){
     lateinit var PlantViewTitle:TextView
     lateinit var PlantViewpic:ImageView
     lateinit var PlantViewWeb:WebView
      lateinit var layout: LinearLayout

      override fun onCreate(savedInstanceState: Bundle?)
      {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_planet_viewr)
            PlantViewTitle = findViewById(R.id.PlantViewText)
            PlantViewpic = findViewById(R.id.PlantViewImage)
            PlantViewWeb = findViewById(R.id.PlantViewWeb)
            layout =findViewById(R.id.linerlayout)

            val intent:Intent =Intent(intent)
            val pos = intent.getIntExtra(KEY_POSITION,0)
            layout.setBackgroundResource(R.drawable.mountain)
            if (pos != 100){
                  PlantViewTitle.text = planetslist[pos]
                  PlantViewpic.setImageResource(planImagId[pos])
            } else {
                  PlantViewTitle.text = getText(R.string.solarsystem)
                  PlantViewpic.setImageResource(R.drawable.solarsystem)
            }
            if (loacallang == "العربية")
            {
                  var selectedPlant:String ="artheSun"
                  val plants =ArrayList<String>()
                  for (planet in SolarSystemPlanets.values()) plants.add("ar${planet.name}")
                  selectedPlant = if (pos != 100) plants[pos] else "artheSun"
                  val website = if (pos == 0) "file:///android_asset/artheSun.html" else if (pos == 100) "file:///android_asset/arsolarsystem.html"  else "file:///android_asset/$selectedPlant.html"
                  PlantViewWeb.loadUrl(website)
            }
            else
            {
            val website = if (pos == 0) "file:///android_asset/theSun.html" else if (pos == 100) "file:///android_asset/solarsystem.html"  else "file:///android_asset/${planetslist[pos]}.html"
            PlantViewWeb.loadUrl(website)
            }
      }


}