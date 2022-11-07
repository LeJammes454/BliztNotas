package com.lejammes454.bliztnotas.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notas")
class Notes:java.io.Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Int?= null

    @ColumnInfo(name = "titulo")
    var titulo:String?= null

    @ColumnInfo(name = "sub_titulo")
    var subtitulo:String?= null

    @ColumnInfo(name = "date_time")
    var dateTime:String?= null

    @ColumnInfo(name = "nota_Texto")
    var notaTexto:String?= null

    @ColumnInfo(name = "img_path")
    var imgPath:String?= null

    @ColumnInfo(name = "color")
    var color:String?= null

    @ColumnInfo(name = "vid_path")
    var vidPath:String?= null


    override fun toString(): String {
        return "$titulo : $dateTime"
    }
}