package com.example.demo2.KafkaListner;

import com.example.demo2.Model.DriverDetails;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "eventRec", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


//  @KafkaListener(topics = "httpReq", groupId = "group_id",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(DriverDetails driverDetails) {
//        System.out.println("Consumed JSON Message: " + driverDetails);
//   }

}


