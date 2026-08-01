package com.hasantuncay.mobsec.secure.storage.maswe0002

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SecureRecord::class], version = 1, exportSchema = false)
abstract class SecureDatabase : RoomDatabase() {
    abstract fun secureRecordDao(): SecureRecordDao
}
