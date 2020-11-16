package com.sourabh.hotelreservation.servicetest

import com.sourabh.hotelreservation.model.Customer
import com.sourabh.hotelreservation.model.Room
import com.sourabh.hotelreservation.model.Transaction
import com.sourabh.hotelreservation.repository.CustomerRepository
import com.sourabh.hotelreservation.service.CancellationService
import com.sourabh.hotelreservation.service.RoomService
import com.sourabh.hotelreservation.service.TransactionService
import org.json.JSONObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.util.*

@SpringBootTest
class CancellationServiceTest {
    @InjectMocks
    var cancellationService: CancellationService? = null

    @Mock
    var customerRepository: CustomerRepository? = null

    @Mock
    var roomService: RoomService? = null

    @Mock
    var transactionService: TransactionService? = null


    @Test
    fun getCustomerTest() {
        val customer = Customer(1, "Sourabh", "Suit", 6, 6000F, true, LocalDateTime.now(), "UPI", true)
        Mockito.`when`(customerRepository!!.findById(1)).thenReturn(Optional.of(customer))
        Assertions.assertEquals(customer, cancellationService!!.getCustomer(1))
    }

    @Test
    fun cancelRoomTest() {
        val customer = Customer(1, "Sourabh", "Suit", 6, 6000F, true, LocalDateTime.now(), "UPI", true)
        Mockito.`when`(customerRepository!!.findById(1)).thenReturn(Optional.of(customer))

        val room = Room(1, "Suit", 1200F, 12, true)
        Mockito.`when`(roomService!!.findByType("Suit")).thenReturn(room)

        val transaction = Transaction(1, customer, 6000F)
        Mockito.`when`(transactionService!!.getById(1)).thenReturn(transaction)
        val actual = cancellationService!!.cancelRoom(1)
        val obj = JSONObject(actual)
        Assertions.assertEquals(4800, obj["Refund"])
    }
    @Test
    fun cancelRoomTest2() {
        val customer = Customer(1, "Sourabh", "Suit", 6, 6000F, false, LocalDateTime.now(), "UPI", true)
        Mockito.`when`(customerRepository!!.findById(1)).thenReturn(Optional.of(customer))

        val room = Room(1, "Suit", 1200F, 12, true)
        Mockito.`when`(roomService!!.findByType("Suit")).thenReturn(room)

        val transaction = Transaction(1, customer, 6000F)
        Mockito.`when`(transactionService!!.getById(1)).thenReturn(transaction)

        val actual = cancellationService!!.cancelRoom(1)
        val obj = JSONObject(actual)
        Assertions.assertEquals(0, obj["Refund"])
    }



}