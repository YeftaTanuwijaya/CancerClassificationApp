package com.dicoding.asclepius.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryCancerDao {

    @Insert
    suspend fun addToHistory(historyCancer: HistoryCancer)

    @Query("SELECT * FROM history_cancer ORDER BY id DESC")
    fun getHistoryCancer(): LiveData<List<HistoryCancer>>

}