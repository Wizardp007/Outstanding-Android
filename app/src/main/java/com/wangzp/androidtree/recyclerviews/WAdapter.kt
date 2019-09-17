package com.wangzp.androidtree.recyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wangzp.androidtree.R

class WAdapter(private val context: Context, private val data: List<ObjectData>) : RecyclerView.Adapter<WAdapter.WViewHoler> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WViewHoler {
       return WViewHoler(LayoutInflater.from(context).inflate(R.layout.item_drag,parent,false))
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }



    override fun onBindViewHolder(holder: WViewHoler, position: Int) {
        var data = data.get(position)

    }



    inner class WViewHoler(view: View):RecyclerView.ViewHolder(view){

    }

}