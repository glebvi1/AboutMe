package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface Item: Parcelable {
    @Parcelize
    data class Skills(val skills: List<Skill>): Item
    @Parcelize
    data class ProfileItem(val myProject: MyProject): Item
    @Parcelize
    data class Header(val header: String) : Item
    @Parcelize
    data class ProjectInfo(val idea: String, val info: String) : Item
}