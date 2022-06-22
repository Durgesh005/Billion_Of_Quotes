package com.example.example_1.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example_1.Adapter.CategoryAdapter
import com.example.example_1.Utils.CategoryModal
import com.example.example_1.Utils.DBHelper
import com.example.example_1.Utils.DataBaseModal
import com.example.example_1.databinding.ActivityQuotesShowBinding

class QuotesShow : AppCompatActivity() {
    lateinit var binding: ActivityQuotesShowBinding
    var list2 = ArrayList<DataBaseModal>()
    var list3 = ArrayList<CategoryModal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = DBHelper(this)
        var temp : String? = intent.getStringExtra("n1")

        list2 = db.readData(temp!!)
        list3 = db.CategoryReadData()

        SetupRecyclerView(list2, list3)

    }

    fun SetupRecyclerView(
        l2: ArrayList<DataBaseModal>,
        l3: ArrayList<CategoryModal>
    ) {
        var adapter = CategoryAdapter(this, l2, l3)
        var layoutManager = LinearLayoutManager(this)
        binding.QuotesData.layoutManager = layoutManager
        binding.QuotesData.adapter = adapter
    }

}
