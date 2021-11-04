package com.example.myapplication

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity(application: Application) : AppCompatActivity(),View.OnClickListener {

    private val mrepository = repository.getInstance(application.applicationContext)
    private val mlist = MutableLiveData<List<model>>()
    val list: LiveData<List<model>> = mlist
    private val madapter : MainAdpter = MainAdpter()

    override fun onCreate(savedInstanceState: Bundle?) {
        load()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNovo.setOnClickListener(this)//chamada da função de incluir remdio
        val listagem = findViewById<RecyclerView>(R.id.listagem)
        listagem.layoutManager = LinearLayoutManager(baseContext)
        listagem.adapter = MainAdpter()
        observe()


    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonNovo) {
            openIncluir()
        }

    }

    private fun observe(){
        list.observe(this, androidx.lifecycle.Observer {
            madapter.upguest(it)
        })
    }
    //implementação do botão de incluir novo remédio
    private fun openIncluir() {
        val intent = Intent(this, IncluirActivity::class.java)
        startActivity(intent)

    }
    fun load(){
       mlist.value = mrepository.getAll()
    }


}