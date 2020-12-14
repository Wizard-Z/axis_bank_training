package com.sourabh.demo.events;

import com.sourabh.demo.model.Customer;
import com.sourabh.demo.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelListener extends AbstractMongoEventListener<Customer> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public void customerModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Customer> event) {
        if (event.getSource().getCid() < 1) {
            event.getSource().setCid(sequenceGenerator.generateSequence(Customer.SEQUENCE_NAME)+100);
        }
    }


}