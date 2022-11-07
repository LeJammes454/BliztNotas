package com.lejammes454.bliztnotas.DB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotaDao {
    @Query("SELECT * FROM Notas ORDER BY id DESC")
    suspend fun getAllNotes():List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertarnotas(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)
}