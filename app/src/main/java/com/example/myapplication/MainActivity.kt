package com.example.myapplication

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.view.View
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNovo.setOnClickListener(this)//chamada da função de incluir remdio
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonNovo) {
            openIncluir()
        }


    }

    //implementação do botão de incluir novo remédio
    private fun openIncluir() {
        val intent = Intent(this, IncluirActivity::class.java)
        startActivity(intent)
    }


}