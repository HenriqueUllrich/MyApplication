package com.example.myapplication

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.guest.view.*

class MainViw(itemView: View):RecyclerView.ViewHolder(itemView) {
    fun bind(guest: model){
        val item = itemView.findViewById<TextView>(R.id.text)
        item.text = guest.nome
    }
}