package com.booking.model

import java.sql.Date
import java.util.Calendar


data class Customers(val cid:Int,
                     val name: String,
                     val type: String,
                     val days: Int,
                     val total_fair: Float,
                     val full_pay: String,
                     val pay_method: String,
                     var bookDate: Date=Date(Calendar.getInstance().time.time),
                     val status:Int=0 )

/*
TODO: Implement Singleton design
 */