package com.example.myapplication.data

import com.example.myapplication.model.Skill

class Data(val skills: ArrayList<Skill>, var filterSkills: ArrayList<Skill> = skills) {

    fun setFilter(filterParam: ArrayList<String>) {
        filterSkills = ArrayList()

        for (s in skills) {
            if (filterParam.contains(s.ex)) {
                filterSkills.add(s)
            }
        }
    }

    fun getFilter(): List<Skill> {
        return filterSkills
    }
}
