package com.sourabh.hotelreservation.model

import io.swagger.annotations.ApiModel
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "customersK")
@ApiModel(description = "Details about the Customer.")
data class Customer(@Id var cid: Int = 0,
                    var name: String = "",
                    var type: String = "",
                    var days: Int = 0,
                    var totalFair: Float = 0F,
                    var fullPay: Boolean = true,
                    var bookDate: LocalDateTime = LocalDateTime.now(),
                    var paymentMethod: String = "",
                    var status: Boolean = false)
{
    companion object {
        val SEQUENCE_NAME: String? = "customers_sequence"}
}
