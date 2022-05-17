package com.anil.kisannetworkdemo.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
class CartResponse(
    var s_id: String,
    var qty: String,
    var s_name: String,
    var s_fees: String,
    var s_total: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}