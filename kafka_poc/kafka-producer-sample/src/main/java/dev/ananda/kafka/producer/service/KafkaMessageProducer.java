package dev.ananda.kafka.producer.service;

import java.util.UUID;

import com.google.protobuf.Message;
import com.azibo.classification.proto.TransactionTag.ClassificationUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class KafkaMessageProducer {
	
	
	@Autowired
    private KafkaTemplate<String, ClassificationUpdateDto> kafkaTemplate;
	
	/*public void sendMessage(String Topic, String message) {
        log.error( "-----> New message ==> {}", message );
        this.kafkaTemplate.send( Topic, message );
        log.error( "New message adde............" );
    }*/

    public void publishProtoMessage(String topic, ClassificationUpdateDto request) {

        log.error( "-----> New message ==> {}", request.toString()  );
        this.kafkaTemplate.send( topic, UUID.randomUUID().toString(), request );
        log.error( "New message added............" );
    }

    /*public void publishProtoMessage(String topic, String payload) {
        log.error( "-----> New message ==> {}", payload );
        this.kafkaTemplate.send( topic, payload.getBytes() );
        log.error( "New message adde............" );
    }*/
}
