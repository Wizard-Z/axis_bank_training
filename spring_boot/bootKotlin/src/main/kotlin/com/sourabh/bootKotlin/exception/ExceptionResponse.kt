package com.sourabh.bootKotlin.exception

import java.time.LocalDateTime

data class ExceptionResponse(val message:String,
                             val timestamp:LocalDateTime) {
}