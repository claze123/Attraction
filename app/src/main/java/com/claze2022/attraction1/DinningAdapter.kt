package com.claze2022.attraction1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.claze2022.attraction1.databinding.RecyclerviewDinningBinding

class DinningAdapter constructor(val context: Context, var dinningitems: MutableList<DinningItem>) : RecyclerView.Adapter<DinningAdapter.VH>() {
    inner class VH constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: RecyclerviewDinningBinding = RecyclerviewDinningBinding.bind(itemView)
        init {
            binding.fab.setOnClickListener(object: View.OnClickListener{
                override fun onClick(p0: View?) {
                    val intent = Intent(context, EditActivity::class.java)
                    intent.putExtra("POST_SJ",dinningitems[adapterPosition].POST_SJ)
                    intent.putExtra("POST_SN",dinningitems[adapterPosition].POST_SN)
                    ContextCompat.startActivity(context, intent, null)


                }

            })
            binding.ivBoard.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val intent = Intent(context, BoardActivity::class.java)
                    intent.putExtra("POST_SJ",dinningitems[adapterPosition].POST_SJ)
                    intent.putExtra("POST_SN",dinningitems[adapterPosition].POST_SN)
                    ContextCompat.startActivity(context, intent, null)
                }

            })

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemview: View =
            LayoutInflater.from(context).inflate(R.layout.recyclerview_dinning, parent, false)
        return VH(itemview)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.binding.tvDinningname.text = dinningitems[position].POST_SJ
        holder.binding.tvDinniglanguage.text = dinningitems[position].LANG_CODE_ID
        holder.binding.tvDinningaddr.text = dinningitems[position].NEW_ADDRESS
        holder.binding.tvDinningmenu.text = dinningitems[position].FD_REPRSNT_MENU
        holder.binding.tvDinningphone.text = dinningitems[position].CMMN_TELNO
        holder.binding.tvDinningtime.text = dinningitems[position].CMMN_USE_TIME
        holder.binding.tvDinningweb.text = dinningitems[position].CMMN_HMPG_URL
        holder.binding.tvDinningtraffic.text = dinningitems[position].SUBWAY_INFO


    }

    override fun getItemCount(): Int = dinningitems.size

}
