package com.booking.model

import java.sql.Date
import java.util.*

data class Transactions(val cid:Int,
                        val name: String,
                        val amount: Float,
                        var bookDate: Date = Date(Calendar.getInstance().time.time))