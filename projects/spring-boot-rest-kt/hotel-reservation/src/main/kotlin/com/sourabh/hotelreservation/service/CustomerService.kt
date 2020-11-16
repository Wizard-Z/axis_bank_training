package com.sourabh.hotelreservation.service

import com.sourabh.hotelreservation.exception.SomethingNotFoundException
import com.sourabh.hotelreservation.iservice.ICustomerService
import com.sourabh.hotelreservation.model.Customer
import com.sourabh.hotelreservation.model.Transaction
import com.sourabh.hotelreservation.repository.CustomerRepository
import com.sourabh.hotelreservation.repository.TypeOccupant
import org.bson.Document
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.stereotype.Service
import java.time.LocalDateTime
@Service
class CustomerService(@Autowired var roomService: RoomService,
                               @Autowired var customerRepository: CustomerRepository,
                               @Autowired var transactionService: TransactionService,
                               @Autowired var sequenceGeneratorService: SequenceGeneratorService) :ICustomerService{
    private var logger:Logger = LoggerFactory.getLogger(this.javaClass)

    override fun addCustomer(customer: Customer): Customer {
        if(customer.days<=0)
            throw SomethingNotFoundException("Invalid no. of days");
        val roomDetails = roomService.findByTypeAvailable(customer.type)
        var baseFare = roomDetails.price
        customer.cid = sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME)+100
        customer.totalFair=calculateFare(customer.days, baseFare)
        customer.status=true
        customer.bookDate= LocalDateTime.now()
        logger.info("\n\n----\ndetails: $customer\n")
        roomService.updateRoomCount(roomDetails,-1)

        val amount = if(customer.fullPay)
            customer.totalFair
        else
            baseFare
        val transaction= Transaction(customer.cid,customer,amount)
        logger.info("----\n$customer\n------")
        logger.info(("-----\n[TRANSACTION]\n $transaction \n"))
        transactionService.addOrUpdate(transaction)
        return customerRepository.save(customer)

    }

    override fun getAll(): MutableList<Customer> {
        val customers = customerRepository.findAll()
        if(customers.isEmpty())
            throw SomethingNotFoundException("NO CUSTOMER DATA YET!")
        return customers
    }

    override fun getOccupantsCounts():Document {
       return customerRepository.getOccupantCounts()?.rawResults ?: throw SomethingNotFoundException("Empty Hotels!")
    }

    override fun getOccupantsCountHistory(): Document {
        return customerRepository.getOccupantCountsHistory()?.rawResults?:throw SomethingNotFoundException("Empty Occupants History!")
    }

    override fun getCustomer(id: Int): Customer {
        return customerRepository.findById(id).orElseThrow{ SomethingNotFoundException("No Customer present for the given ID: $id")}
    }

    override fun calculateFare(days: Int, baseFare: Float): Float {
        return if(days>=5)
            (days-1)*baseFare
        else
            days*baseFare
    }

    override fun getDateWiseBookings(): Document {
        return customerRepository.getDateWiseBooking()?.rawResults ?: throw SomethingNotFoundException("Datewise Booking not available")
    }
}