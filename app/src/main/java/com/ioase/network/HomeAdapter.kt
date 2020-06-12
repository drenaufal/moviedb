package com.ioase.network

import android.view.*
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_home.view.*
import java.text.FieldPosition

class HomeAdapter(private val results: List<Result>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder{
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false)
        )
    }

        override fun onBindViewHolder(holder: HomeViewHolder, position: Int){
            holder.bind(results[holder.adapterPosition])
        }

    override fun getItemCount(): Int {
        return results.count()
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(result: Result){
            with(itemView){
                val title = findViewById<TextView>(R.id.judul)
                title.text = result.title

                val overview = findViewById<TextView>(R.id.overview)
                overview.text = result.overview

                val release_date = findViewById<TextView>(R.id.release_date)
                release_date.text = result.release_date
            }
        }
    }
}