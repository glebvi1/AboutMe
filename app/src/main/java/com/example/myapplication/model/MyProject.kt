package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyProject(var name: String, var imageSrc: Int, var class1: String) : Parcelable {
}