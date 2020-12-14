package com.sourabh.demoappservice.kafkas;

import com.sourabh.demoappservice.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ProduceK {
    //Step 1-create topic
    @Bean
    NewTopic testTransaction(){
        return new NewTopic("testTransaction",3,(short) 3);
    }
    //Step 2-Kafka Template
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void produce(Transaction transaction){
        kafkaTemplate.send("testTransaction",transaction).addCallback(result -> {
            if (result != null) {
                final long offset = result.getRecordMetadata().offset();
                final int partition = result.getRecordMetadata().partition();
                System.out.println("{Offset: "+offset+"partition = " + partition);
            }

        }, ex -> System.err.println("not today"));

    }




}
