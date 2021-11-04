package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import java.lang.Exception

class repository private constructor(context: Context){
    private var mdatabase : database = database(context)
    companion object{
        private lateinit var repository:  repository
        fun getInstance(context: Context):repository{
            if(!::repository.isInitialized){
                repository=repository(context)
            }
            return repository(context)
        }
    }
    @SuppressLint("Range")
    fun getAll():List<model> {
        val list: MutableList<model> = ArrayList()
        return try {
            val db = mdatabase.readableDatabase

            // Colunas que serão retornadas
            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.DIAS,
                DataBaseConstants.GUEST.COLUMNS.HORA,
                DataBaseConstants.GUEST.COLUMNS.MINUTO,
                DataBaseConstants.GUEST.COLUMNS.DOSAGEM,
                DataBaseConstants.GUEST.COLUMNS.VOLUME

            )



            // Faz a seleção
            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection, null,null,null,null,null

            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val dias = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.DIAS))
                    val hora = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.HORA))
                    val minuto = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.MINUTO))
                    val dosagem = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.DOSAGEM))
                    val volume = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.VOLUME))


                    val guest = model(id, name, dias,hora, minuto,dosagem,volume)
                    list.add(guest)
                }


            }

            cursor?.close()
            list
        } catch (e: Exception) {
            list
        }
    }

    fun save(guest: model):Boolean{
        return try {
            val dp  = mdatabase.writableDatabase
            val value= ContentValues()
            value.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.nome)
            value.put(DataBaseConstants.GUEST.COLUMNS.DIAS, guest.dias)
            value.put(DataBaseConstants.GUEST.COLUMNS.HORA, guest.hora)
            value.put(DataBaseConstants.GUEST.COLUMNS.MINUTO, guest.minuto)
            value.put(DataBaseConstants.GUEST.COLUMNS.DOSAGEM, guest.dosagem)
            value.put(DataBaseConstants.GUEST.COLUMNS.VOLUME, guest.volume)
            dp.insert(DataBaseConstants.GUEST.TABLE_NAME, null,value )
            true
        }catch (e:Exception){
            false
        }


    }
    fun update(guest: model):Boolean{
        return try {
            val dp  = mdatabase.writableDatabase
            val value= ContentValues()
            value.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.nome)
            value.put(DataBaseConstants.GUEST.COLUMNS.DIAS, guest.dias)
            value.put(DataBaseConstants.GUEST.COLUMNS.HORA, guest.hora)
            value.put(DataBaseConstants.GUEST.COLUMNS.MINUTO, guest.minuto)
            value.put(DataBaseConstants.GUEST.COLUMNS.DOSAGEM, guest.dosagem)
            value.put(DataBaseConstants.GUEST.COLUMNS.VOLUME, guest.volume)
            val selection=DataBaseConstants.GUEST.COLUMNS.ID +"= ?"
            val args = arrayOf(guest.id.toString())
            dp.update(DataBaseConstants.GUEST.TABLE_NAME,value,selection, args)
            true
        }catch (e:Exception){
            false
        }

    }
    fun delte(guest: model){
        fun update(guest: model):Boolean{
            return try {
                val dp  = mdatabase.writableDatabase

                val selection=DataBaseConstants.GUEST.COLUMNS.ID +"= ?"
                val args = arrayOf(guest.id.toString())
                dp.delete(DataBaseConstants.GUEST.TABLE_NAME,selection, args)
                true
            }catch (e:Exception){
                false
            }

        }
    }
}


