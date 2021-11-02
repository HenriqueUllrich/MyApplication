package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DataBaseConstants private constructor() {


    object GUEST {
        const val TABLE_NAME = "Guest"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val DIAS = "dias"
            const val HORA = "hora"
            const val MINUTO = "minuto"
            const val DOSAGEM = "dosagem"
            const val VOLUME = "volume"
        }
    }
}

class database(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION ) {

    override fun onCreate(db:SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_GUEST)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "remedio.db"
        private const val CREATE_TABLE_GUEST =
            ("create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
                    + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
                    + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.DIAS + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.HORA + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.MINUTO + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.DOSAGEM + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.VOLUME + " int);")
    }

}