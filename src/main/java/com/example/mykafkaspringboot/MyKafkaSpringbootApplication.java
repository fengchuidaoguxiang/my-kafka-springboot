package com.example.mykafkaspringboot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.HashMap;

@SpringBootApplication
public class MyKafkaSpringbootApplication {

    /**
     * 消费者DEMO
     */
    @KafkaListener(topics="t3", groupId = "g1")
    public void receive(ConsumerRecord<String, String> record  ){
        System.out.println(record.key()
                    + "\t" + record.value()
                    + "\t" + record.timestamp()
                    + "\t" + record.offset()
                    + "\t" + record.partition()
                    + "\t" + record.topic()
         );
    }

    public static void main(String[] args) {
        SpringApplication.run(MyKafkaSpringbootApplication.class, args);
    }

}
