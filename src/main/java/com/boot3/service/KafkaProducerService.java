package com.boot3.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {
    private final static String TOPIC_NAME = "sample-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendWithCallback(String msg){

        String jsonInInString = "";
        ObjectMapper mapper = new ObjectMapper();

        try{
            jsonInInString = mapper.writeValueAsString(msg);

            log.debug("##### jsonInInString : " + jsonInInString);
        } catch(JsonProcessingException ex){
            ex.printStackTrace();
            log.debug("##### ex : " + ex);
        }

        log.info("sending message {}", jsonInInString);

        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(TOPIC_NAME, jsonInInString);

        String finalJsonInInString = jsonInInString;
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.debug("Message sent successfully");
                log.info("successfully sent message = {}, with offset = {}", finalJsonInInString,
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Failed to send message = {}, error = {}", finalJsonInInString, ex.getMessage());
                log.debug("Message sending failed = 메시지 전송 실패...");
            }
        });
    }

}
