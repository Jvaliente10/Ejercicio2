package com.example.joseantoniovaliente.ejercicio2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Element(val name:String,val latitud:String,val longitud:String, val image:String):Parcelable
