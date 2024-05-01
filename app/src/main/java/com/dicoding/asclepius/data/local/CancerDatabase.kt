package com.dicoding.asclepius.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (
    entities = [HistoryCancer::class],
    version = 1
)
abstract class CancerDatabase:RoomDatabase() {
    companion object {
        var INSTANCE : CancerDatabase? = null

        fun getDatabase(context: Context): CancerDatabase? {
            if (INSTANCE == null) {
                synchronized(CancerDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, CancerDatabase::class.java, "cancer_database").build()
                }
            }
            return INSTANCE
        }
    }

    abstract fun historyCancerDao(): HistoryCancerDao

}