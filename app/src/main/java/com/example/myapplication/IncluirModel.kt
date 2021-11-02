package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IncluirModel:ViewModel() {
    val mrepository: repository = repository()
    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveguest: LiveData<Boolean> = mSaveGuest
    fun save(nome:String, dias: Int, hora: Int, minuto:Int,dosagem: String, volume:Int ){
           var guest = model(nome, dias, hora, minuto, dosagem, volume)
            mrepository.save(guest)
    }
}