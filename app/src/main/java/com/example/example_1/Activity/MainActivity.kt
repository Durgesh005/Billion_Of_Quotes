package com.example.example_1.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.example_1.Adapter.DataAdapter
import com.example.example_1.Utils.CategoryModal
import com.example.example_1.Utils.DBHelper
import com.example.example_1.Utils.DataBaseModal
import com.example.example_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var list2 = ArrayList<DataBaseModal>()
    var list3 = ArrayList<CategoryModal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = DBHelper(this)
        list3 = db.CategoryReadData()

        SetupRecyclerView(list3)
    }

    fun SetupRecyclerView(l1: ArrayList<CategoryModal>) {

        var adapter = DataAdapter(this, l1)
        var layoutManager = GridLayoutManager(this, 3)
        binding.RvView.layoutManager = layoutManager
        binding.RvView.adapter = adapter


    }
}
