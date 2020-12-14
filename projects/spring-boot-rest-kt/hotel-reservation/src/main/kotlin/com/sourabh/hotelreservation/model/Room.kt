package com.sourabh.hotelreservation.model

import io.swagger.annotations.ApiModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.stereotype.Component


@Document(collection = "roomK")
@ApiModel(description = "Details about the Room model.")
data class Room (@Id var id:Int,
                 var type:String,
                 var price:Float,
                 var left:Int,
                 var available:Boolean){
}