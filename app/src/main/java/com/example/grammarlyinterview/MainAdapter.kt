package com.example.grammarlyinterview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(var context: Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    var itemList = arrayListOf<Int>(0,0,0,0)
    var pauseList = arrayListOf<Int>()


    inner class MainViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.textView_show).text= itemList[position].toString()
        holder.itemView.setOnClickListener {
            Log.e("position",position.toString())
            if(pauseList.contains(position)){
                pauseList.remove(position)
            }else{
                pauseList.add(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    fun updateList(i:Int){
        val temp= arrayListOf<Int>()
        temp.addAll(itemList)


        itemList.clear()
//        itemList.addAll(newList)

        for(x:Int in 0..19){
           if(pauseList.contains(x)){
               itemList.add(temp[x])
           }else{
               itemList.add(i)
           }

        }
        Log.e("ITEMLIST",itemList.toString())

        notifyDataSetChanged()
    }
}


