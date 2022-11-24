package com.furkansenol.workwithroom.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "user_table"
)
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @ColumnInfo(name="firstName")
    val  firstName:String,

    @ColumnInfo(name="lastName")
    val lastName:String,

    @ColumnInfo(name="age")
    val age:Int
):Parcelable //serializable dan daha hızlı