package com.vmware.tanzulabs.schemaregistry.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.cloud.stream.schema.registry.client.EnableSchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
@EnableSchemaRegistryClient
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, byte[]> sensorProducerFactory( final KafkaProperties kafkaProperties ) {

        Map<String, Object> configProps = kafkaProperties.buildProducerProperties();

        return new DefaultKafkaProducerFactory<>( configProps );
    }

    @Bean
    public KafkaTemplate<String, byte[]> sensorKafkaTemplate( ProducerFactory<String, byte[]> sensorProducerFactory ) {

        return new KafkaTemplate<>( sensorProducerFactory );
    }

}
