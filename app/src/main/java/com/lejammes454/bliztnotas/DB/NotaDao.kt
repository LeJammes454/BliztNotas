package com.lejammes454.bliztnotas.DB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotaDao {
    @get:Query("SELECT * FROM Notas ORDER BY id DESC")
    val allNotes: List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertarnotas(note: Notes)

    @Delete
    fun deleteNote(note: Notes)
}