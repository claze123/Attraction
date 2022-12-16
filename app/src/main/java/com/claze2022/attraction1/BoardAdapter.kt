package com.claze2022.attraction1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claze2022.attraction1.databinding.RecyclerviewBoardBinding

class BoardAdapter constructor(val context: Context, val items: MutableList<BoardItem>):RecyclerView.Adapter<BoardAdapter.VH>(){
    inner class VH constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding : RecyclerviewBoardBinding = RecyclerviewBoardBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.recyclerview_board, parent, false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.tvBoardmessage.text = items[position].message
        holder.binding.tvPostSj.text = items[position].POST_SJ
        holder.binding.tvWritetime.text = items[position].date


    }

    override fun getItemCount(): Int = items.size
}