package com.dicoding.asclepius.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.asclepius.data.local.History
import com.dicoding.asclepius.data.local.HistoryCancer
import com.dicoding.asclepius.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var adapter: HistoryAdapter
    private val mainViewModel by viewModels<HistoryViewModel>()

    override fun onResume() {
        super.onResume()
        mainViewModel.getHistoryCancer()?.observe(this) { historyCancerList ->
            if (historyCancerList != null) {
                val list = mapList(historyCancerList)
                adapter.setList(list)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        mainViewModel.getHistoryCancer()?.removeObservers(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = HistoryAdapter()

        binding.apply {
            rvHistories.setHasFixedSize(true)
            rvHistories.layoutManager = LinearLayoutManager(this@HistoryActivity)
            rvHistories.adapter = adapter
        }

        mainViewModel.getHistoryCancer()?.observe(this) {
            if (it != null) {
                val list = mapList(it)
                adapter.setList(list)
            }
        }
    }

    private fun mapList(histories: List<HistoryCancer>): ArrayList<History> {
        val listHistories = ArrayList<History>()
        for (history in histories) {
            val historyMapped = History(
                history.id,
                history.image,
                history.result
            )
            listHistories.add(historyMapped)
        }
        return listHistories
    }


}