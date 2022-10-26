package dev.ananda.kafka.producer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Data
@Component
public class KafkaProperties
{
    @Value ("${kafka.brokers}")
    private String bootstrapServers;

    @Value ("${kafka.security_protocol:}")
    private String securityProtocol;

    @Value ("${kafka.sasl_mechanism:}")
    private String saslMechanism;

    @Value ("${kafka.sasl_jaas_config:}")
    private String saslJaasConfig;
}