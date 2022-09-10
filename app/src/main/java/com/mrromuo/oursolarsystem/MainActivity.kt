package com.mrromuo.oursolarsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.mrromuo.oursolarsystem.data.SolarSystemPlanets
import com.mrromuo.oursolarsystem.listadapters.MyListAdapter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
      var solarSystemView: ImageView? = null
      var listView: ListView? = null
      var myAdapter: MyListAdapter? = null
      var menubutton:ImageButton? = null

      companion object {
            var planetslist = ArrayList<String>()
            val planImagId = ArrayList<Int>()
            const val KEY_POSITION = "POSITION"
            var loacallang:String ="Arabic"
      }

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            loacallang = Locale.getDefault().getDisplayLanguage()
            //Toast.makeText(this, loacallang,Toast.LENGTH_LONG).show()
            menubutton = findViewById(R.id.imageButton)
            solarSystemView = findViewById(R.id.imageView)
            solarSystemView?.setImageResource(R.drawable.main_solrsystem)
            solarSystemView?.setOnClickListener(){
                  val inline =Intent(this,PlanetViewr::class.java)
                  inline.putExtra(KEY_POSITION,100)
                  startActivity(inline)
            }
            menubutton?.setOnClickListener(){
                  val popupMenu: PopupMenu = PopupMenu(this,menubutton)
                  popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
                  popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                        var intent:Intent = Intent(this,WebViewer::class.java)
                        when(item.itemId) {
                              R.id.three ->
                                   intent = Intent(this,comingsoon::class.java)
                              R.id.four ->
                                    intent = Intent(this,comingsoon::class.java)
                              R.id.five ->
                                    intent = Intent(this,comingsoon::class.java)
                              R.id.one ->
                                    intent = Intent(this,comingsoon::class.java)
                              R.id.two ->
                                    intent = Intent(this,comingsoon::class.java)
                        }
                        startActivity(intent)
                        true
                  })
                  popupMenu.show()
            }
            listView = findViewById(R.id.selectinglist)
            if (loacallang=="العربية") {getArabicPlanets()}else{getPlanets()}

            myAdapter = MyListAdapter(this, planetslist)
            listView?.adapter = myAdapter

      }

      private fun getArabicPlanets() {
            if (planetslist.size < 1 && loacallang == "العربية") {
                  for (aplant in SolarSystemPlanets.values()) {
                        planImagId.add(aplant.photo)
                  }
                  val list: Array<out String> = resources.getStringArray(R.array.selectingmain)
                  for (item in list) planetslist.add(item)

      } else getPlanets()
      }

      fun getPlanets() {
            if (planetslist.size < 1) {
                  for (aplant in SolarSystemPlanets.values()) {
                        val plantname = aplant.name
                        planetslist.add(plantname)
                        planImagId.add(aplant.photo)
                  }
            }
      }

}