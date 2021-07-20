package com.example.todolist.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.model.Note
import org.w3c.dom.Text

class NoteAdapter(private val notes: List<Note>): RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var iNameView: TextView? = null
        var iCategoryView: TextView? = null
        var iDateView: TextView? = null

        init{
            iNameView = itemView.findViewById(R.id.iNameView)
            iCategoryView = itemView.findViewById(R.id.iCategoryView)
            iDateView = itemView.findViewById(R.id.iDateView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycle_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.iNameView!!.text = notes[position].name
        holder.iDateView!!.text = notes[position].date
        holder.iCategoryView!!.text = notes[position].category

    }

    override fun getItemCount(): Int {
        return notes.size
    }
}