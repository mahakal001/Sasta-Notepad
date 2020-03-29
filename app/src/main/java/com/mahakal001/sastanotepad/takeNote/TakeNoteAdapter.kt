package com.mahakal001.sastanotepad.takeNote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mahakal001.sastanotepad.R
import com.mahakal001.sastanotepad.convertLongToDateString
import com.mahakal001.sastanotepad.database.Notes

class TakeNoteAdapter : RecyclerView.Adapter<TakeNoteAdapter.ViewHolder>() {

    var data = listOf<Notes>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder  private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        val notesTiming : TextView = itemView.findViewById(R.id.note_timing)
        val noteString : TextView = itemView.findViewById(R.id.note_string)

         fun bind(
            item: Notes
        ) {
            val res = itemView.context.resources
            notesTiming.text = convertLongToDateString(item.recordTiming)
            noteString.text = item.notes
        }

        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_all_notes, parent, false)
                return ViewHolder(view)
            }
        }

    }


}

