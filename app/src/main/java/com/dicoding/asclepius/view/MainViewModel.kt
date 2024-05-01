package com.dicoding.asclepius.view

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import com.dicoding.asclepius.data.local.CancerDatabase
import com.dicoding.asclepius.data.local.HistoryCancer
import com.dicoding.asclepius.data.local.HistoryCancerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var cancerDao: HistoryCancerDao?
    private var cancerDb: CancerDatabase?

    init {
        cancerDb = CancerDatabase.getDatabase(application)
        cancerDao = cancerDb?.historyCancerDao()
    }

    fun addToHistory(image: Uri?, result: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val user = HistoryCancer(
                image = image,
                result = result
            )
            cancerDao?.addToHistory(user)
        }
    }

}