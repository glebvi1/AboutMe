package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Skill

class SkillsAdapter(private val skills: List<Skill>)
    : RecyclerView.Adapter<SkillsAdapter.SkillsHolder>() {

    class SkillsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var skill: TextView = itemView.findViewById(R.id.skill)
        private var ex: TextView = itemView.findViewById(R.id.ex)

        fun onBind(item: Skill) {
            skill.text = item.skill
            ex.text = item.ex
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsAdapter.SkillsHolder =
        SkillsHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false))

    override fun onBindViewHolder(holder: SkillsAdapter.SkillsHolder, position: Int) {
        holder.onBind(skills[position])
    }

    override fun getItemCount(): Int = skills.size
}
