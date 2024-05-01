package com.dicoding.asclepius.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dicoding.asclepius.data.local.CancerDatabase
import com.dicoding.asclepius.data.local.HistoryCancer
import com.dicoding.asclepius.data.local.HistoryCancerDao

class HistoryViewModel(application: Application): AndroidViewModel(application) {

    private var cancerDao: HistoryCancerDao?
    private var cancerDb: CancerDatabase?

    init {
        cancerDb = CancerDatabase.getDatabase(application)
        cancerDao = cancerDb?.historyCancerDao()
    }

    fun getHistoryCancer(): LiveData<List<HistoryCancer>>? {
        return cancerDao?.getHistoryCancer()
    }

}