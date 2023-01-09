package com.boot3.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KafkaConsumerService {
    private final static String TOPIC_NAME = "sample-topic";

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessage(String jsonMsg) throws NullPointerException {
        log.info("kafka msg : " + jsonMsg);

        // 역직렬화
        Map<String, String> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(jsonMsg, new TypeReference<Map<String, String>>() {
            });

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}