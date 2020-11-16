package com.sourabh.hotelreservation.model

import io.swagger.annotations.ApiModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.stereotype.Component



@Document(collection = "transactionK")
@ApiModel(description = "Details about the Customer.")
data class Transaction(@Id var id:Int=0,
                  var customer: Customer,
                  var amount:Float ) {
}