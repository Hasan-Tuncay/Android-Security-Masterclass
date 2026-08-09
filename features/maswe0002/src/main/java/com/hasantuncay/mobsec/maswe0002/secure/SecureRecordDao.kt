package com.hasantuncay.mobsec.maswe0002.secure

import com.hasantuncay.mobsec.maswe0002.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SecureRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: SecureRecord)

    @Query("SELECT * FROM secure_records LIMIT 1")
    suspend fun getFirst(): SecureRecord?
}
