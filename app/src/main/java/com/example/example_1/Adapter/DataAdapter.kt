package com.example.example_1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example_1.Activity.QuotesShow
import com.example.example_1.R
import com.example.example_1.Utils.CategoryModal

class DataAdapter(val quotesShow: QuotesShow, val list3: ArrayList<CategoryModal>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(quotesShow).inflate(R.layout.categoryview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.category.text = list3[position].categoryname

    }

    override fun getItemCount(): Int {
        return list3.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category = itemView.findViewById<TextView>(R.id.category_txt)
    }
}