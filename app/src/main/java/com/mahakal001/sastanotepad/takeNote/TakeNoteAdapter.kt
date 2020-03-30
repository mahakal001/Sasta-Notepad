package com.mahakal001.sastanotepad.takeNote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahakal001.sastanotepad.convertLongToDateString
import com.mahakal001.sastanotepad.database.Notes
import com.mahakal001.sastanotepad.databinding.ListAllNotesBinding

class TakeNoteAdapter : ListAdapter<Notes, TakeNoteAdapter.ViewHolder>( NotesDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder  private constructor(val binding: ListAllNotesBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind( item: Notes ) {
            binding.notes =     item
            binding.executePendingBindings()
        }

        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = ListAllNotesBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }
    }

}

class NotesDiffCallback : DiffUtil.ItemCallback<Notes>() {
    override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return oldItem.noteId == newItem.noteId
    }

    override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return oldItem == newItem
    }


}

