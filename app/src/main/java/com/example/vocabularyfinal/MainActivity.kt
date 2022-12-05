package com.example.vocabularyfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity(), IVocabRVAdapter {

    lateinit var viewModel: VocabViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter  = VocabRVAdapter(this,this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allVocab.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }
        })
    }

    override fun onItemClicked(vocab: Vocab) {
        viewModel.deleteVocab(vocab)
        Toast.makeText(this, "${vocab.text} Deleted", Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        val vocabText = input.text.toString()
        if(vocabText.isNotEmpty()){
            viewModel.insertVocab(Vocab(vocabText))
            Toast.makeText(this, "${vocabText} Deleted", Toast.LENGTH_LONG).show()
        }
    }
}