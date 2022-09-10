package com.mrromuo.oursolarsystem.data

import com.mrromuo.oursolarsystem.R

enum class SolarSystemPlanets(val isitPlanet: Boolean = false,
                              val isitMoon:Boolean = false,
                              val isitastoroid:Boolean = false,
                              val isitaStar:Boolean = false,
                              val photo:Int = 0) {
      Sun(isitaStar = true, photo = (R.drawable.sun250)),
      Mercury(isitPlanet = true, photo = (R.drawable.mercury250)),
      Venus(isitPlanet = true, photo = (R.drawable.venus250)),
      Earth(isitPlanet = true, photo = (R.drawable.earth250)),
      Mars(isitPlanet = true, photo = (R.drawable.mars250)),
      Asteroidbelt(photo = (R.drawable.asteroidbilt250)),
      Ceres(photo= (R.drawable.ceres250)),
      Jupiter(isitPlanet = true, photo = (R.drawable.jupiter250)),
      Saturn(isitPlanet = true, photo = (R.drawable.saturn250)),
      Uranus(isitPlanet = true, photo = (R.drawable.uranus250)),
      Neptune(isitPlanet = true, photo = (R.drawable.neptune250)),
      Pluto(photo= (R.drawable.pluto250))
}