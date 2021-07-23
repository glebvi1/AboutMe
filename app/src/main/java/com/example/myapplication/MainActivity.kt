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
        val projectInfo = "Когда у школьника возникает желение научиться чему-то новому, то ему " +
                "может понадобиться учитель. Репититоры дороги и не всегда эффективны.\n" +
                "Мы предлагаем другое решение: наше приложение позволяет находить школьников, " +
                "готовых обмениваться знаниями.\n" +
                "Например, 1-й школьник умеет петь, но не умеет танцевать (хочет научиться), ему нужно" +
                " найти другого школьника, умееющего танцевать, но не умееющего петь (хочет науиться)." +
                "Наше приложение позволяет осуществить поиск."

        val myProject = MyProject(
            "Вязов Глеб", R.drawable.ic_launcher_background, "Закончил 9 класс")
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
        val header: Item.Header = Item.Header("Мои навыки")
        val skills: Item.Skills = Item.Skills(skill)

        return listOf(project, Item.ProjectInfo("SkillsExchange", projectInfo), header, skills)
    }
}