package com.example.foodstore


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodstore.databinding.ActivityMainBinding
import com.example.foodstore.databinding.AddNewItemBinding


lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val urlimg2="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSK6ghC4OB1yk7uqJoEupPCdoFFfYecE5J_UQ&usqp=CAU"
        val Foodlist= arrayListOf<Food>(
            Food("pizza","15","2","tehran",urlimg2,20,1f),
            Food("kebab","20","50","isfahan",urlimg2,20,1f),
            Food("pasta","10","13","karaj",urlimg2,20,1f),
            Food("falafel","7","60","ilam",urlimg2,40,2f),
            Food("jooje","19","40","semnan",urlimg2,50,2.5f),
            Food("hotdog","10","8","ghom",urlimg2,80,4f),
            Food("rice","5","12","ghzvin",urlimg2,20,1f),



            )

        val myAdopter=FoodAdopter(Foodlist,this)
        binding.recyclerFood.adapter=myAdopter;
        binding.recyclerFood.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)


        binding.addFoods.setOnClickListener{

            val dialog =AlertDialog.Builder(this)
            val dialogBinding=AddNewItemBinding.inflate(layoutInflater)
            dialog.setView(dialogBinding.root)
            dialog.setCancelable(true)
            dialog.create()
            dialog.show()






        }
    }
}