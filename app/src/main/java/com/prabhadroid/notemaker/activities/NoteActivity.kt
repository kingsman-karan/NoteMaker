package com.prabhadroid.notemaker.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.prabhadroid.notemaker.R
import com.prabhadroid.notemaker.models.Note
import com.prabhadroid.notemaker.utils.Constants
import com.prabhadroid.notemaker.utils.showToast
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {

    companion object {
        val TAG : String = NoteActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        Log.d(TAG, "onCreate called!")

        val existingNote: Note = intent.extras.getSerializable(Constants.NOTE_KEY) as Note

        existingNote?.let {
            showToast("Got ${existingNote.noteTitle}")
            txt_note_title.text = existingNote.noteTitle
            txt_note_content.text = existingNote.noteContent
            btn_back.text = resources.getString(R.string.back_button)
        }

        btn_back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@NoteActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}