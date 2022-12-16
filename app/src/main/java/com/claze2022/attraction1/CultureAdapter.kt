package com.claze2022.attraction1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.claze2022.attraction1.databinding.RecyclerviewCultureBinding

class CultureAdapter constructor(val context: Context, var items: MutableList<CultureItem>) : RecyclerView.Adapter<CultureAdapter.VH>() {
    inner class VH constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: RecyclerviewCultureBinding = RecyclerviewCultureBinding.bind(itemView)
        init {
            binding.fab.setOnClickListener(object:View.OnClickListener{
                override fun onClick(p0: View?) {
                    val intent: Intent = Intent(context,EditActivity::class.java)
                    intent.putExtra("POST_SJ",items[adapterPosition].POST_SJ)
                    intent.putExtra("POST_SN",items[adapterPosition].POST_SN)

                    ContextCompat.startActivity(context, intent,null)

                }
            })

            binding.ivBoard.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val intent = Intent(context, BoardActivity::class.java)
                    intent.putExtra("POST_SJ",items[adapterPosition].POST_SJ)
                    intent.putExtra("POST_SN",items[adapterPosition].POST_SN)
                    ContextCompat.startActivity(context, intent, null)
                }

            })
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.recyclerview_culture, parent, false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.tvKorean.text = items[position].LANG_CODE_ID
        holder.binding.tvName.text = items[position].POST_SJ
        holder.binding.tvAddress.text = items[position].NEW_ADDRESS
        holder.binding.tvTel.text = items[position].CMMN_TELNO
        holder.binding.tvWeb.text = items[position].CMMN_HMPG_URL
        holder.binding.tvWorkday.text = items[position].CMMN_BSNDE
        holder.binding.tvHoliday.text = items[position].CMMN_RSTDE
        holder.binding.tvTime.text = items[position].CMMN_USE_TIME
        holder.binding.tvTraffic.text = items[position].SUBWAY_INFO
    }

    override fun getItemCount(): Int = items.size

}
