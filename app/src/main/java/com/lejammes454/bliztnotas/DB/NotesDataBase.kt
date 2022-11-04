package com.lejammes454.bliztnotas.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDataBase:RoomDatabase() {
    companion object{
        var notesDataBase:NotesDataBase?=null
        @Synchronized
        fun getDataBase(context:Context):NotesDataBase{
            if (notesDataBase != null){
                notesDataBase = Room.databaseBuilder(
                    context,
                    NotesDataBase::class.java,
                    "Notes DB"
                ).build()
            }
            return notesDataBase!!
        }
    }
    abstract fun noteDao():NotaDao
}