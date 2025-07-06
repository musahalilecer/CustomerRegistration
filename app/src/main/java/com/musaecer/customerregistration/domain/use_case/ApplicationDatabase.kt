package com.musaecer.customerregistration.domain.use_case

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.musaecer.customerregistration.data.local.CustomerEntity
import com.musaecer.customerregistration.domain.dao.CustomerDao

@Database(
    entities = [CustomerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao

    companion object {
        @Volatile private var INSTANCE: ApplicationDatabase? = null

        fun getInstance(context: Context): ApplicationDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ApplicationDatabase::class.java,
                    "application_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
    }
}