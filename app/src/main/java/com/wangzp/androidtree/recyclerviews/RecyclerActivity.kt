package com.wangzp.androidtree.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wangzp.androidtree.R
import com.wangzp.androidtree.recyclerviews.viewhlper.ItemTounchHelper
import androidx.recyclerview.widget.ItemTouchHelper



class RecyclerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        var recyclerview = findViewById<RecyclerView>(R.id.rl_cyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        var mData: ArrayList<ObjectData> = ArrayList<ObjectData>()
        for (i in 0..6){
            mData.add(ObjectData())
        }
        var mAdapter = WAdapter(this,mData)
        recyclerview.adapter = mAdapter

        val helper = ItemTouchHelper(ItemTounchHelper(mData,mAdapter))
        helper.attachToRecyclerView(recyclerview)
    }



}
