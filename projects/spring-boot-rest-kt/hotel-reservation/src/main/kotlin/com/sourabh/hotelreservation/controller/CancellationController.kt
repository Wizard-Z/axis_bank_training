package com.sourabh.hotelreservation.controller

import com.sourabh.hotelreservation.service.CancellationService
import org.springframework.beans.factory.annotation.Autowired
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class CancellationController {
    @Autowired
    var cancellationService: CancellationService? = null


    @ApiOperation(value = "Enter customer-id to cancel booking.", notes = """Provide c.id and based on it booking will be cancelled
Refund will be calculated.""")
    @DeleteMapping("/cancellations/{id}")
    fun cancelRoom(@PathVariable id: Int): String {
        return cancellationService!!.cancelRoom(id)
    }
}
