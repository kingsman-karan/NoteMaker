package com.prabhadroid.notemaker.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import com.prabhadroid.notemaker.R
import com.prabhadroid.notemaker.adapters.NotesAdapter
import com.prabhadroid.notemaker.models.NoteSupplier
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG : String = MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate: Called..!")
        //setupHeader()

        setupRecyclerView()
    }

    private fun setupHeader() {
        txt_notes_header.setSingleLine()
        txt_notes_header.ellipsize = TextUtils.TruncateAt.MARQUEE
        txt_notes_header.marqueeRepeatLimit = -1
        txt_notes_header.isSelected = true
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_noteList.layoutManager = layoutManager
        val adapter = NotesAdapter(this,NoteSupplier.sampleNoteList)
        recycler_noteList.adapter = adapter
    }

}
