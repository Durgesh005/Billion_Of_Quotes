package com.example.example_1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example_1.Adapter.CategoryAdapter
import com.example.example_1.Utils.DBHelper
import com.example.example_1.Utils.DataBaseModal
import com.example.example_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var list2 = ArrayList<DataBaseModal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = DBHelper(this)
        list2 = db.readData()


        var adapter = CategoryAdapter(this, list2)
        var layoutManager = LinearLayoutManager(this)
        binding.RvView.layoutManager = layoutManager
        binding.RvView.adapter = adapter


    }


}
