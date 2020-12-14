package com.sourabh.hotelreservation.events

import com.sourabh.hotelreservation.model.Customer
import com.sourabh.hotelreservation.service.SequenceGeneratorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent
import org.springframework.stereotype.Component


@Component
class CustomerModelListener : AbstractMongoEventListener<Customer>() {
    private var sequenceGenerator: SequenceGeneratorService? = null
    @Autowired
    fun customerModelListener(sequenceGenerator: SequenceGeneratorService?) {
        this.sequenceGenerator = sequenceGenerator
    }

    override fun onBeforeConvert(event: BeforeConvertEvent<Customer>) {
        if (event.source.cid < 1) {
            event.source.cid=(sequenceGenerator!!.generateSequence(Customer.SEQUENCE_NAME) + 100)
        }
    }
}