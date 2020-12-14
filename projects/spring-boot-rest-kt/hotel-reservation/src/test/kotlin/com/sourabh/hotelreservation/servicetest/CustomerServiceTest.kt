package com.sourabh.hotelreservation.servicetest

import com.sourabh.hotelreservation.exception.SomethingNotFoundException
import com.sourabh.hotelreservation.model.Customer
import com.sourabh.hotelreservation.model.Room
import com.sourabh.hotelreservation.repository.CustomerRepository
import com.sourabh.hotelreservation.service.CustomerService
import com.sourabh.hotelreservation.service.RoomService
import com.sourabh.hotelreservation.service.SequenceGeneratorService
import com.sourabh.hotelreservation.service.TransactionService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

@SpringBootTest
class CustomerServiceTest {
    @InjectMocks
    var customerService: CustomerService? = null

    @Mock
    var roomService: RoomService? = null

    @Mock
    var customerRepository: CustomerRepository? = null

    @Mock
    var transactionService: TransactionService? = null

    @Mock
    var sequenceGenerator: SequenceGeneratorService? = null

    @Test
    fun addCustomerTest() {
        val customer = Customer(name = "Sourabh", type = "Suit", fullPay = true, days = 5, paymentMethod = "UPI")
        val room = Room(1, "Suit", 1200F, 12, true)
        Mockito.`when`(roomService!!.findByTypeAvailable("Suit")).thenReturn(room)
        Mockito.`when`(sequenceGenerator!!.generateSequence(Customer.SEQUENCE_NAME)).thenReturn(1)
        val modifiedCustomer = Customer()
        modifiedCustomer.name="Sourabh"
        modifiedCustomer.type="Suit"
        modifiedCustomer.days=5
        modifiedCustomer.paymentMethod="UPI"
        modifiedCustomer.status=true
        modifiedCustomer.cid=101
        modifiedCustomer.totalFair=4800F
        modifiedCustomer.fullPay=true
        modifiedCustomer.bookDate=LocalDateTime.now()
        Mockito.`when`(customerRepository!!.save(customer)).thenReturn(modifiedCustomer)
        Assertions.assertEquals(modifiedCustomer, customerService!!.addCustomer(customer))
    }

    @Test
    fun addCustomerTest2() {
        val customer = Customer(name = "Sourabh", type = "Suit", fullPay = true, days = 0, paymentMethod = "UPI")
        Assertions.assertThrows(SomethingNotFoundException::class.java) { customerService?.addCustomer(customer) }
    }

        @Test
    fun getAllTest() {
        val customers: MutableList<Customer> = ArrayList()
        val customer1 = Customer(1, "Sourabh", "Suit", 6, 6000F, true, LocalDateTime.now(), "UPI", true)
        val customer2= Customer(2, "SourabhOther", "Single-Bed", 6, 6000F, true, LocalDateTime.now(), "UPI", true)
        val customer3= Customer(3, "Hello-again", "Dormitory", 5, 6000F, true, LocalDateTime.now(), "UPI", true)
        customers.add(customer1)
        customers.add(customer2)
        customers.add(customer3)
        Mockito.`when`(customerRepository!!.findAll()).thenReturn(customers)
        Assertions.assertEquals(3, customerService?.getAll()?.size)
    }
    @Test
    fun getCustomerTest(){
        val customer=Customer(1, "Sourabh", "Suit", 6, 6000F, true, LocalDateTime.now(), "UPI", true)
        Mockito.`when`(customerRepository!!.findById(1)).thenReturn(Optional.of(customer))
        Assertions.assertEquals(customer.name, customerService!!.getCustomer(1).name)
    }
    @Test
    fun calculateFareTest(){
        val days=5;
        val baseFare = 1200F
        val expected = 4800F
        Assertions.assertEquals(expected,customerService!!.calculateFare(days,baseFare))
    }


}