package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.MyProjectAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Item
import com.example.myapplication.model.MyProject
import com.example.myapplication.model.Skill

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MyProjectAdapter(data())

        setContentView(binding.root)
    }

    private fun data(): List<Item> {
        val projectInfo = getString(R.string.project_info)

        val myProject = MyProject(
            getString(R.string.name), R.drawable.ic_launcher_background, getString(R.string.class1))
        val skill: List<Skill> = listOf(
            Skill("Python", "3 year"),
            Skill("Java Spring", "1 year"),
            Skill("Java Android", "1 year"),
            Skill("SQL", "1 year"),
            Skill("LaTeX", "1 year"),
            Skill("ML", "3 month"),
            Skill("Kotlin", "1 month")
        )

        val project: Item.ProfileItem = Item.ProfileItem(myProject)
        val header: Item.Header = Item.Header(getString(R.string.my_skills))
        val skills: Item.Skills = Item.Skills(skill)

        return listOf(project, Item.ProjectInfo(getString(R.string.project_name), projectInfo), header, skills)
    }
}
