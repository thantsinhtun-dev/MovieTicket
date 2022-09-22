package com.stone.movieticket.data.vos

import com.google.gson.annotations.SerializedName

data class PaymentVO(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String?,
    @SerializedName("description")
    val description:String?,
    var isSelected:Boolean=false

)
