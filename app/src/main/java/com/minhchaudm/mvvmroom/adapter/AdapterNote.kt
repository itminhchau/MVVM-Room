package com.minhchaudm.mvvmroom.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.minhchaudm.mvvmroom.R
import com.minhchaudm.mvvmroom.model.Note

class AdapterNote(
        private val context: Context,
        private val onClick:(Note)-> Unit,
        private val onDelete: (Note)->Unit
):RecyclerView.Adapter<AdapterNote.NoteViewHolder>() {
    private var listNote: List<Note> = listOf()
    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val txtTitle: TextView = itemView.findViewById(R.id.item_title)
        private val txtDescription: TextView = itemView.findViewById(R.id.item_description)
        private val imageTrash: ImageView = itemView.findViewById(R.id.image_trash)
        private val itemLayout: ConstraintLayout = itemView.findViewById(R.id.item_layout)
        fun onBind(note: Note){
            txtTitle.text = note.title
            txtDescription.text = note.description
            imageTrash.setOnClickListener {
                onDelete(note)
            }

            itemLayout.setOnClickListener{
                onClick(note)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemNoteView: View = LayoutInflater.from(context).inflate(R.layout.item_note,parent,false)
        return NoteViewHolder(itemNoteView)
    }

    override fun getItemCount(): Int = listNote.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       holder.onBind(listNote[position])
    }
    fun setNote(note: List<Note>){
        this.listNote = note
        notifyDataSetChanged()
    }
    fun getNote(position: Int): String{
        return listNote[position].toString()
    }
}