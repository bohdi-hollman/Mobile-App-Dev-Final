package com.example.vocabularyfinal

import androidx.room.*

@Dao
interface VocabDao {

    @Query("SELECT * FROM vocab_table ORDER BY id ASC")
    fun getAlphabetizedVocab(): List<Vocab>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vocab: Vocab)

    @Query("DELETE FROM vocab_table")
    suspend fun deleteAll()
}