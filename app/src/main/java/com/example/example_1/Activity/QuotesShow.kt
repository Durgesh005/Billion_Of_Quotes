package com.example.example_1.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example_1.Adapter.CategoryAdapter
import com.example.example_1.R
import com.example.example_1.Utils.CategoryModal
import com.example.example_1.Utils.DBHelper
import com.example.example_1.Utils.DataBaseModal
import com.example.example_1.databinding.ActivityQuotesShowBinding

class QuotesShow : AppCompatActivity() {
    lateinit var binding: ActivityQuotesShowBinding
    var list2 = ArrayList<DataBaseModal>()
    var list3 = ArrayList<CategoryModal>()

    var images = intArrayOf(
        R.drawable.m2,
        R.drawable.love_birds,
        R.drawable.sad,
        R.drawable.success,
        R.drawable.happy1,
        R.drawable.traveller,
        R.drawable.friend,
        R.drawable.life,
        R.drawable.working,
        R.drawable.family,
        R.drawable.attitudde2,
        R.drawable.zyanm
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = DBHelper(this)
        var temp: String? = intent.getStringExtra("n1")

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        list2 = db.readData(temp!!)
        list3 = db.CategoryReadData()




        SetupRecyclerView(list2, list3,images)

    }

    fun SetupRecyclerView(
        l2: ArrayList<DataBaseModal>,
        l3: ArrayList<CategoryModal>,
        images: IntArray
    ) {
        var adapter = CategoryAdapter(this, l2, l3,images)
        var layoutManager = LinearLayoutManager(this)
        binding.QuotesData.layoutManager = layoutManager
        binding.QuotesData.adapter = adapter
    }

}
