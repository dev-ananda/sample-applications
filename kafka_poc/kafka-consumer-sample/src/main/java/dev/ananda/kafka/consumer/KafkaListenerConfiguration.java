package dev.ananda.kafka.consumer;


import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.Message;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


@EnableKafka
@Configuration
public class KafkaListenerConfiguration <T extends Message>
{
    @Value ("${spring.kafka.bootstrap-servers}")
    private String consumerBootstrapServers;


    @Bean
    public Map<String, Object> consumerConfiguration()
    {
        Map<String, Object> consumerConfig = new HashMap<>();
        consumerConfig.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerBootstrapServers );
        consumerConfig.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class );
        consumerConfig.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaProtobufDeserializer.class );
        consumerConfig.put( KafkaProtobufDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        //consumerConfig.put( KafkaProtobufDeserializerConfig.SPECIFIC_PROTOBUF_VALUE_TYPE, TransactionUpdateRequest.class.getName());
        return consumerConfig;
    }


    @Bean
    public ConsumerFactory<String, T> consumerFactory()
    {
        return new DefaultKafkaConsumerFactory<>( consumerConfiguration() );
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, T> kafkaListenerContainerFactory()
    {
        ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory( consumerFactory() );
        factory.setBatchListener( true );
        return factory;
    }
}
