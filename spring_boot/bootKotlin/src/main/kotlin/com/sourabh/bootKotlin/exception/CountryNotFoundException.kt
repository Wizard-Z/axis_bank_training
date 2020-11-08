package com.sourabh.bootKotlin.exception

import java.lang.RuntimeException

class CountryNotFoundException(message:String) :RuntimeException(message) {
}