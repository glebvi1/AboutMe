package com.example.myapplication.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.filter.FilterActivity
import com.example.myapplication.model.Item

class MyProjectAdapter(private val context: Context,
                       private val items: List<Item>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class MyProjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var image: ImageView = itemView.findViewById(R.id.image)
        private var name: TextView = itemView.findViewById(R.id.name)
        private var class1: TextView = itemView.findViewById(R.id.class1)
        private var github: Button = itemView.findViewById(R.id.github)

        fun onBind(item: Item.ProfileItem) {
            name.text = item.myProject.name
            class1.text = item.myProject.class1

            image.setImageResource(item.myProject.imageSrc)

            github.setOnClickListener {
                val uri = Uri.parse("http://github.com/glebvi1")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(itemView.context, intent,null)
            }
        }
    }

    inner class HeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var header: TextView = itemView.findViewById(R.id.header)
        private var filter: ImageButton = itemView.findViewById(R.id.filter_button)

        fun onBind(item: Item.Header) {
            header.text = item.header

            filter.setOnClickListener {
                Log.i("FilterActivity", "Intent to FilterActivity")
                val intent = Intent(context, FilterActivity::class.java)
                startActivity(context, intent, null)
            }
        }
    }

    class ItemSkillsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var recyclerView: RecyclerView = itemView.findViewById(R.id.skills)

        fun onBind(item: Item.Skills) {
            with (recyclerView) {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = SkillsAdapter(item.skills)
            }
        }
    }

    class ProjectInfoHeader(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var info: TextView = itemView.findViewById(R.id.info)
        private var idea: TextView = itemView.findViewById(R.id.idea)

        fun onBind(item: Item.ProjectInfo) {
            idea.text = item.idea
            info.text = item.info
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType) {
            VIEW_TYPE_MY_PROJECT->
                MyProjectHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_my_project, parent, false))
            VIEW_TYPE_HEADER->
                HeaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false))
            VIEW_TYPE_SKILLS ->
                ItemSkillsHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_skills, parent, false))
            VIEW_TYPE_PROJECT_INFO ->
                ProjectInfoHeader(LayoutInflater.from(parent.context).inflate(R.layout.item_project_info, parent, false))
            else ->
                throw IllegalArgumentException("")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val item = items[position]){
            is Item.ProfileItem ->
                (holder as? MyProjectHolder)?.onBind(item)
            is Item.Header ->
                (holder as? HeaderHolder)?.onBind(item)
            is Item.Skills ->
                (holder as? ItemSkillsHolder)?.onBind(item)
            is Item.ProjectInfo ->
                (holder as? ProjectInfoHeader)?.onBind(item)
        }
    }

    override fun getItemViewType(position: Int): Int=
        when(items[position]){
            is Item.ProfileItem ->
                VIEW_TYPE_MY_PROJECT
            is Item.Header ->
                VIEW_TYPE_HEADER
            is Item.Skills ->
                VIEW_TYPE_SKILLS
            is Item.ProjectInfo ->
                VIEW_TYPE_PROJECT_INFO
        }

    override fun getItemCount(): Int = items.size

    companion object {
        const val VIEW_TYPE_MY_PROJECT = 0
        const val VIEW_TYPE_HEADER = 1
        const val VIEW_TYPE_SKILLS = 2
        const val VIEW_TYPE_PROJECT_INFO = 3
    }
}