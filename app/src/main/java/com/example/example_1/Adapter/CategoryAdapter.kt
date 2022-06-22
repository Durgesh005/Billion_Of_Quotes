package com.example.example_1.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example_1.Utils.DataBaseModal
import com.example.example_1.Activity.MainActivity
import com.example.example_1.Activity.QuotesShow
import com.example.example_1.R
import com.example.example_1.Utils.CategoryModal

class CategoryAdapter(
    val factivity: QuotesShow,
    var list2: ArrayList<DataBaseModal>,
    val list3: ArrayList<CategoryModal>,

    ) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(factivity).inflate(R.layout.quotesview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt.text = list2[position].quote
    }

    override fun getItemCount(): Int {
        Log.e("TAG", "getItemCount: " + list2.size)
        return list2.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt = itemView.findViewById<TextView>(R.id.QuotesTxt)

    }
}