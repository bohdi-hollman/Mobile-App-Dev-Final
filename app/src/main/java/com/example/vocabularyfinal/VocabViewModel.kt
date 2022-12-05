package com.example.vocabularyfinal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VocabViewModel(application: Application): AndroidViewModel(application) {

    private val repository: VocabRepository
    val allVocab: LiveData<List<Vocab>>

    init {
        val dao = VocabDatabase.getDatabase(application).getVocabDao()
        repository = VocabRepository(dao)
        allVocab = repository.allVocab
    }

    fun deleteVocab(vocab: Vocab) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(vocab)
    }

    fun insertVocab(vocab: Vocab) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(vocab)
    }
}
