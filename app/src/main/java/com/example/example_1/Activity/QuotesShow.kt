package com.example.example_1.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example_1.Adapter.DataAdapter
import com.example.example_1.Utils.CategoryModal
import com.example.example_1.Utils.DBHelper
import com.example.example_1.databinding.ActivityQuotesShowBinding

class QuotesShow : AppCompatActivity() {
    lateinit var binding: ActivityQuotesShowBinding
    var list3 = ArrayList<CategoryModal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = DBHelper(this)
        list3 = db.CategoryReadData()
        SetupRecyclerView()

    }

    fun SetupRecyclerView() {
        var adapter = DataAdapter(this, list3)
        var layoutManager = LinearLayoutManager(this)
        binding.QuotesData.layoutManager = layoutManager
        binding.QuotesData.adapter = adapter

    }
}