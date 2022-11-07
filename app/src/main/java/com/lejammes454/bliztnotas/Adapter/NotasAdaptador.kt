package com.lejammes454.bliztnotas.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lejammes454.bliztnotas.DB.Notes
import com.lejammes454.bliztnotas.R
import kotlinx.android.synthetic.main.item_rv_notes.view.*

class NotasAdaptador (val arrlist:List<Notes>):
    RecyclerView.Adapter<NotasAdaptador.NotesViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_notes,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return arrlist.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.itemView.tvTitle.text=arrlist[position].titulo
        holder.itemView.tvDesc.text=arrlist[position].notaTexto
        holder.itemView.tvDateTime.text=arrlist[position].dateTime


        if (arrlist[position].color != null){
            holder.itemView.cardView.setCardBackgroundColor(Color.parseColor(arrlist[position].color))
        }else{
            holder.itemView.cardView.setCardBackgroundColor(Color.parseColor("#171c26"))
        }
    }

    class NotesViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

}