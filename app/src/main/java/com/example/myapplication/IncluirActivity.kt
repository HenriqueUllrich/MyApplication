package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_incluir.*

class IncluirActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var mViwModel: IncluirModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incluir)

        mViwModel= ViewModelProvider(this).get(IncluirModel::class.java)
        setListeners()
        observe()
    }
    private fun observe(){
        mViwModel.saveguest.observe(this, Observer {
            if(it){
                Toast.makeText(applicationContext, "Salvo",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(applicationContext, "Falha",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setListeners() {
        buttonSalvar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id=v.id
        if(id==R.id.buttonSalvar){
            val nome= Remedio.text.toString()
            var dias =0
            if(checkBox.isChecked==true) {
                dias=0
            }else
                dias = Dias.text.toString().toInt()

                val hora= timePicker1.hour.toInt()
                val minuto=timePicker1.minute.toInt()
                val dosagem = dosagem.text.toString()
                val volume = number_picker.value.toInt()
                mViwModel.save(nome, dias, hora, minuto, dosagem, volume)
        }

    }
}