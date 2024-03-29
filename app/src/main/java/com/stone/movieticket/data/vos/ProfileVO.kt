package com.stone.movieticket.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.stone.movieticket.persistance.typeconverters.CardTypeConverter

@Entity(tableName = "Profile")
@TypeConverters(
    CardTypeConverter::class
)
data class ProfileVO(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String?,

    @SerializedName("email")
    @ColumnInfo(name = "email")
    val email: String?,

    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    val phone: String?,

    @SerializedName("total_expense")
    @ColumnInfo(name = "total_expense")
    val totalExpense: Int?,

    @SerializedName("profile_image")
    @ColumnInfo(name = "profile_image")
    val profileImage: String?,

    @SerializedName("cards")
    @ColumnInfo(name = "cards")
    val cards:List<CardVO>?
)
