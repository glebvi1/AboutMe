package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.MyProjectAdapter
import com.example.myapplication.data.Data
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
        recyclerView.adapter = MyProjectAdapter(this, getRecyclerViewData())

        setContentView(binding.root)
    }

    private fun getRecyclerViewData(): List<Item> {
        val projectInfo = getString(R.string.project_info)

        val myProject = MyProject(
            getString(R.string.name), R.drawable.ic_launcher_background, getString(R.string.class1))

        val project: Item.ProfileItem = Item.ProfileItem(myProject)
        val header: Item.Header = Item.Header(getString(R.string.my_skills))
        val skills: Item.Skills = Item.Skills(skillsData.getFilter())

        return listOf(project, Item.ProjectInfo(getString(R.string.project_name), projectInfo), header, skills)
    }

    companion object {
        private val skills = arrayListOf<Skill>(
            Skill("Python", "3 года"),
            Skill("Java Spring", "1 год"),
            Skill("Java Android", "1 год"),
            Skill("SQL", "1 год"),
            Skill("LaTeX", "1 год"),
            Skill("ML", "3 месяца"),
            Skill("Kotlin", "1 месяц")
        )

        var skillsData: Data = Data(skills)
    }
}
