package com.lejammes454.bliztnotas.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notas")
data class Notes (
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "titulo")
    var titulo:String,

    @ColumnInfo(name = "sub_titulo")
    var subtitulo:String,

    @ColumnInfo(name = "date_time")
    var dateTime:String,

    @ColumnInfo(name = "nota_Texto")
    var notaTexto:String,

    @ColumnInfo(name = "img_path")
    var imgPath:String,

    @ColumnInfo(name = "color")
    var color:String,

    @ColumnInfo(name = "vid_path")
    var vidPath:String

    ) :java.io.Serializable {
    override fun toString(): String {
        return "$titulo : $dateTime"
    }
}