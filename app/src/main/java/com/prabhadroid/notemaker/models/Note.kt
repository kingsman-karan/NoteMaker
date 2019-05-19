package com.prabhadroid.notemaker.models

import java.io.Serializable

data class Note(var noteTitle:String, var noteContent:String, var timeStamp:String) : Serializable


object NoteSupplier {
    var sampleNoteList = arrayListOf<Note>(
                    Note("First Note", "This is my first Note", "10:27 am"),
                    Note("Second Note", "This is my Second Note", "11:27 am"),
                    Note("Third Note", "This is my Third Note", "12:27 am"),
                    Note("Fourth Note", "This is my Fourth Note", "10:27 am"),
                    Note("Fifth Note", "This is my Fifth Note", "10:27 am"),
                    Note("Sixth Note", "This is my Sixth Note", "10:27 am"),
                    Note("First Note", "This is my first Note", "10:27 am"),
                    Note("First Note", "This is my first Note", "10:27 am"),
                    Note("First Note", "This is my first Note", "10:27 am"),
                    Note("First Note", "This is my first Note", "10:27 am"),
                    Note("First Note", "This is my first Note", "10:27 am"),
                    Note("First Note", "This is my first Note", "10:27 am"),
                    Note("First Note", "This is my first Note", "10:27 am"),
                    Note("First Note", "This is my first Note", "10:27 am")
    )
}