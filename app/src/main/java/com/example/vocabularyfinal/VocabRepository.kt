package com.example.vocabularyfinal

import androidx.lifecycle.LiveData

class VocabRepository(private val vocabDao: VocabDao) {

    val allVocab: LiveData<List<Vocab>> = vocabDao.getAllVocab()
    suspend fun insert(vocab: Vocab) {
        vocabDao.insert(vocab)
    }

    suspend fun delete(vocab: Vocab) {
        vocabDao.delete(vocab)
    }
}