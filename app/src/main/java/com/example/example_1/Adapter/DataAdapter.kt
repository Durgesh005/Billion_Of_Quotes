package com.example.example_1.Adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.example_1.Activity.MainActivity
import com.example.example_1.Activity.QuotesShow
import com.example.example_1.R
import com.example.example_1.Utils.CategoryModal
import com.example.example_1.Utils.DataBaseModal
import org.w3c.dom.Text
import kotlin.math.acos

class DataAdapter(
    val quotesShow: MainActivity,
    val list3: ArrayList<CategoryModal>
) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(quotesShow).inflate(R.layout.categoryview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.category.text = list3[position].categoryname
        holder.check.text = list3[position].number


        var number = list3[position].number



        holder.cardview.setOnClickListener {

            val intent = Intent(quotesShow, QuotesShow::class.java)
            intent.putExtra("n1", number)
            quotesShow.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list3.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category = itemView.findViewById<TextView>(R.id.category_txt)
        var check = itemView.findViewById<TextView>(R.id.IdCheck)
        var cardview = itemView.findViewById<CardView>(R.id.CardView)
    }
}