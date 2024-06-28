package com.example.foodstore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class FoodAdopter(private val data:List<Food>,private val context:Context): RecyclerView.Adapter<FoodAdopter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View,):RecyclerView.ViewHolder(itemView){
        val img=itemView.findViewById<ImageView>(R.id.image)
        val subtxt=itemView.findViewById<TextView>(R.id.textView)
        val citytxt=itemView.findViewById<TextView>(R.id.textView2)
        val distancetxt=itemView.findViewById<TextView>(R.id.textView3)
        val pricetxt=itemView.findViewById<TextView>(R.id.textView4)
        val ratingtxt=itemView.findViewById<TextView>(R.id.textView6)
        val ratingbar=itemView.findViewById<RatingBar>(R.id.rating)

        fun bindData(position: Int){
            subtxt.text=data[position].txtSubject;
            citytxt.text=data[position].txtCity
            pricetxt.text="$"+data[position].txtPrice+"vip"
            distancetxt.text=data[position].txtDistance+"miles from you"
            ratingbar.rating=data[position].rating
            ratingtxt.text=data[position].numrating.toString()

            Glide
                .with(context)
                .load(data[position].Urlimage)
                .into(img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindData(position);
    }

    override fun getItemCount(): Int {
        return data.size;
    }
}