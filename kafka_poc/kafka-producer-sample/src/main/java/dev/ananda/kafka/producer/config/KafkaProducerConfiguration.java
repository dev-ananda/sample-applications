package dev.ananda.kafka.producer.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.Message;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializerConfig;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@EnableKafka
@Configuration
public class KafkaProducerConfiguration <T extends Message>
{

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, T> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put( ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class);
        props.put( CommonClientConfigs.GROUP_ID_CONFIG, "classification-service-group" );
        props.put( KafkaProtobufSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081" );

        // security configurations
        props.putAll( securityConfig() );

        return props;
    }


    @Bean
    public Map<String, Object> securityConfig()
    {
        if (  "".equals( kafkaProperties.getSecurityProtocol() ) ) {
            return Collections.emptyMap();
        }
        Map<String, Object> securityConfig = new HashMap<>();
        securityConfig.put( CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kafkaProperties.getSecurityProtocol() );
        securityConfig.put( SaslConfigs.SASL_MECHANISM, kafkaProperties.getSaslMechanism() );
        securityConfig.put( SaslConfigs.SASL_JAAS_CONFIG, kafkaProperties.getSaslJaasConfig() );
        return securityConfig;
    }

    @Bean
    public KafkaTemplate<String, T> kafkaTemplate() {
        return new KafkaTemplate<>( producerFactory() );
    }

}