package com.example.myapplication.filter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.data.Data
import com.example.myapplication.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding

    private var all: CheckBox? = null
    private var treeYears: CheckBox? = null
    private var oneYear: CheckBox? = null
    private var treeMonths: CheckBox? = null
    private var oneMonth: CheckBox? = null

    private var apply: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        all = binding.all
        treeYears = binding.treeYears
        oneYear = binding.oneYear
        treeMonths = binding.treeMonths
        oneMonth = binding.oneMonth
        apply = binding.apply

        var filter: ArrayList<String> = ArrayList()

        all!!.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                filter = ArrayList()

                treeYears!!.isChecked = true
                oneYear!!.isChecked = true
                treeMonths!!.isChecked = true
                oneMonth!!.isChecked = true
            } else {
                treeYears!!.isChecked = false
                oneYear!!.isChecked = false
                treeMonths!!.isChecked = false
                oneMonth!!.isChecked = false
            }
        }

        treeYears!!.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                filter.add("3 года")
            } else {
                filter.remove("3 года")
            }
        }

        oneYear!!.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                filter.add("1 год")
            } else {
                filter.remove("1 год")
            }
        }

        treeMonths!!.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                filter.add("3 месяца")
            } else {
                filter.remove("3 месяца")
            }
        }

        oneMonth!!.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                filter.add("1 месяц")
            } else {
                filter.remove("1 месяц")
            }
        }

        apply!!.setOnClickListener {

            isAll = isAllCheckBox()

            MainActivity.skillsData.setFilter(filter)
            startActivity(Intent(this@FilterActivity, MainActivity::class.java))
        }
    }

    private fun isAllCheckBox(): Boolean {
        return all!!.isChecked ||
                (treeYears!!.isChecked &&
                oneYear!!.isChecked &&
                treeMonths!!.isChecked &&
                oneMonth!!.isChecked)
    }

    companion object {
        var isAll: Boolean = true
    }

}