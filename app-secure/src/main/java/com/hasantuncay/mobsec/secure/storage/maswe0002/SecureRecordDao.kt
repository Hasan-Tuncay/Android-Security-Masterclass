package com.hasantuncay.mobsec.secure.storage.maswe0002

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
