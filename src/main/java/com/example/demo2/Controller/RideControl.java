package com.example.demo2.Controller;

import com.example.demo2.Model.DriverDetails;
import com.example.demo2.Model.RiderDetails;
import com.example.demo2.Repository.RiderDetailsRepository;
import com.example.demo2.Repository.RiderStatusRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("kafka")
public class RideControl {

    @Autowired
    RiderDetailsRepository rideRepo;
    @Autowired
    RiderStatusRepo riderStatusRepo;
    @Autowired
    private RiderDetailsRepository riderDetailsRepository;
        private RiderDetails riderDetails;

//    private kafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, DriverDetails> kafkaTemplate2;

    @GetMapping("/")//this is to view from h2
    public Iterable<RiderDetails> view(HttpServletRequest request, HttpServletResponse response) {

        return riderDetailsRepository.findAll();

    }

    @PostMapping("/save")   //this is to sava in h2
    public void save(@RequestBody RiderDetails r, HttpServletRequest request, HttpServletResponse response) {

        riderDetailsRepository.save(r);


    }

    public static final String TOPIC = "eventRec";

    @GetMapping("/publish/{messege}")
    public String post(@PathVariable("messege")final String messege){
        kafkaTemplate.send(TOPIC,messege);
        return "complete";

    }

//    public String post(@RequestBody RiderDetails riderDetails) {
//        if (riderDetails != null) {
//
//            kafkaTemplate.send(TOPIC, riderDetails);
//        } else {
//            /*Rider Details Are null*/
//            throw new NullPointerException();
//        }
//
//
//        return "complete";
//    }
    @GetMapping("/publish/AcceptDriver")
    public String post(@RequestBody DriverDetails driverDetails) {
        if (driverDetails != null) {
            kafkaTemplate2.send(TOPIC, driverDetails);
        } else {
            /*Rider Details Are null*/
            throw new NullPointerException();
        }


        return "complete";
    }




//    @PostMapping("/ride/{id}/activate")
//    public RiderDetails activeRide(@PathVariable Integer id) {
//        Optional<RiderDetails> ride = rideRepo.findById(id);
//        RideStatus status = ride.getStatus();
//        if (status == RideStatus.PENDING) {
//            ride.get().setStatus(RideType.ACCEPT);
//            rideRepo.save(ride.get());
//            riderStatusRepo.save(new RiderDetails(ride.get().getRiderId(), RideType.ACCEPT));
//
//        } else {
//
//
//        }
//        return ride.get();
//    }



}
