package com.boot3.controller;

import com.boot3.data.dto.MyMsg;
import com.boot3.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {
    @Autowired
    private KafkaProducerService kafkaProducerService;



    @RequestMapping("/publish")
    public String publish(@RequestParam String msg){

        kafkaProducerService.sendWithCallback(msg);
        return "publish msg with callback : " + msg;
    }

}
