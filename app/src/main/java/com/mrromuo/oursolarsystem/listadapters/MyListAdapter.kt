package com.mrromuo.oursolarsystem.listadapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.mrromuo.oursolarsystem.MainActivity
import com.mrromuo.oursolarsystem.MainActivity.Companion.KEY_POSITION
import com.mrromuo.oursolarsystem.PlanetViewr
import com.mrromuo.oursolarsystem.R

class MyListAdapter(val context: Context,val list: ArrayList<String>): BaseAdapter() {

      override fun getCount(): Int {

            return list.size
      }

      override fun getItem(position: Int): Any {
            return position
      }

      override fun getItemId(position: Int): Long {
            return position.toLong()
      }

      @SuppressLint("ViewHolder", "InflateParams")
      override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater:LayoutInflater =LayoutInflater.from(context)
            val view:View=layoutInflater.inflate(R.layout.listlayout,null,false)
            val pic = view.findViewById(R.id.imageinlist) as ImageView
            val textView = view.findViewById(R.id.textInListView) as TextView
            textView.text =list[position]
            pic.setImageResource(MainActivity.planImagId[position])
            pic.setOnClickListener(){
                  val intent =Intent(context,PlanetViewr::class.java)
                  intent.putExtra(KEY_POSITION,position)
                  startActivity(context,intent,intent.extras)
            }
            textView.setOnClickListener(){
                  val intent =Intent(context,PlanetViewr::class.java)
                  intent.putExtra(KEY_POSITION,position)
                  startActivity(context,intent,intent.extras)
            }

            return view
      }
}