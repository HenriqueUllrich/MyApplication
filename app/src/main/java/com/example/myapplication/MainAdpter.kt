package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdpter: RecyclerView.Adapter<MainViw>() {
    private var mlist: List<model> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViw {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.guest,parent,false)
        return MainViw(item)
    }

    override fun onBindViewHolder(holder: MainViw, position: Int) {
        holder.bind(mlist[position])
    }

    override fun getItemCount(): Int {
        return mlist.count()
    }
    fun upguest(list:List<model>) {
        mlist=list

    }
}
