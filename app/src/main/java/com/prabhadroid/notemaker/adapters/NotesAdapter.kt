package com.prabhadroid.notemaker.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prabhadroid.notemaker.R
import com.prabhadroid.notemaker.activities.NoteActivity
import com.prabhadroid.notemaker.models.Note
import com.prabhadroid.notemaker.utils.Constants
import com.prabhadroid.notemaker.utils.showToast
import kotlinx.android.synthetic.main.list_item_notes.view.*

class NotesAdapter(val context : Context, val notesList: ArrayList<Note>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NotesViewHolder {
        val notesView = LayoutInflater.from(context).inflate(R.layout.list_item_notes, parent, false)
        return NotesViewHolder(notesView)
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notesList[position]
        holder.bindNoteData(note, position)
    }

    inner class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var currentNote:Note? = null
        var currentPosition:Int = 0

        init {
            itemView.setOnClickListener {
                currentNote?.let {
                    context.showToast(currentNote!!.noteTitle+" clicked!")
                    val intent = Intent(context, NoteActivity::class.java)
                    intent.putExtra(Constants.NOTE_KEY, currentNote)
                    context.startActivity(intent)
                }

            }
            itemView.ib_delete_note.setOnClickListener {
                currentNote?.let {
                    context.showToast("Do you want to delete ${currentNote!!.noteTitle}?")
                }
            }
        }
        fun bindNoteData(note : Note?, position: Int) {
            note?.let {
                itemView.txt_title.text = note.noteTitle
                itemView.txt_content.text = note.noteContent
                this.currentNote = note
                this.currentPosition = position
            }

        }
    }
}