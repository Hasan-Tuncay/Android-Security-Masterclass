package com.hasantuncay.mobsec.maswe0001.secure

import com.hasantuncay.mobsec.maswe0001.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SecureRecord::class], version = 1, exportSchema = false)
abstract class SecureDatabase : RoomDatabase() {
    abstract fun secureRecordDao(): SecureRecordDao
}
