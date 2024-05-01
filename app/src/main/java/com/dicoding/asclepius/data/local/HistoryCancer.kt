package com.dicoding.asclepius.data.local

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@TypeConverters(UriTypeConverter::class)
@Entity(tableName = "history_cancer")
data class HistoryCancer(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val image: Uri?,
    val result: String
)
