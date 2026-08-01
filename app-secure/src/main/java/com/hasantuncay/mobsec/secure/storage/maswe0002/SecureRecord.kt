package com.hasantuncay.mobsec.secure.storage.maswe0002

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "secure_records")
data class SecureRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "pan")         val pan: String,
    @ColumnInfo(name = "cvv")         val cvv: String,
    @ColumnInfo(name = "pin_block")   val pinBlock: String,
    @ColumnInfo(name = "hipaa_mrn")   val hipaaMrn: String,
    @ColumnInfo(name = "icd10_code")  val icd10Code: String,
    @ColumnInfo(name = "national_id") val nationalId: String
)
