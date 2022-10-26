package dev.ananda.kafka.consumer;


import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import dev.ananda.kafka.proto.TransactionTag.TransactionUpdateRequest;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class TestKafkaListener
{
    @KafkaListener (id = "listener-batch", topics = "${kafka.topic}", groupId = "classification-service-group", containerFactory = "kafkaListenerContainerFactory",
        properties = {ConsumerConfig.MAX_POLL_RECORDS_CONFIG + "=5", ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG + ":io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer"
        })
    public void receive(@Payload ConsumerRecords<String, Message> messages ) throws InvalidProtocolBufferException
    {
        System.err.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.err.println("Starting the process to receive batch messages");

        for ( ConsumerRecord<String, Message> message : messages ) {

            TransactionUpdateRequest request = TransactionUpdateRequest.parseFrom( message.value().toByteArray() );

            System.err.println("received message='" +request.toString()+ "'");
        }
        System.err.println("all the batch messages are consumed");
        System.err.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
