package com.example.vocabularyfinal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class VocabViewModel(application: Application): AndroidViewModel(application) {

    val allVocab: LiveData<List<Vocab>>

    init {
        val dao = VocabDatabase.getDatabase(application).getVocabDao()
        val repository = VocabRepository(dao)
        allVocab = repository.allVocab
    }
}
