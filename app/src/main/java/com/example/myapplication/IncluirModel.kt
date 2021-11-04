package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IncluirModel(application: Application): AndroidViewModel(application) {
    private val mContext = application.applicationContext
    val mrepository: repository = repository.getInstance(mContext)
    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveguest: LiveData<Boolean> = mSaveGuest
    fun save(nome:String, dias: Int, hora: Int, minuto:Int,dosagem: String, volume:Int ){
           var guest = model(0,nome, dias, hora, minuto, dosagem, volume)
            mSaveGuest.value= mrepository.save(guest)
    }
}