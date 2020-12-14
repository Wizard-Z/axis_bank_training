package com.sourabh.hotelreservation.exception

import java.lang.RuntimeException

class SomethingNotFoundException (message:String) : RuntimeException(message) {
}