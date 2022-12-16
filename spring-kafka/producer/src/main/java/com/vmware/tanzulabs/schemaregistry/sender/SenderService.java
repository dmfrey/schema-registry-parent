package com.vmware.tanzulabs.schemaregistry.sender;

import com.vmware.tanzulabs.schemaregistry.records.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.schema.registry.avro.AvroSchemaRegistryClientMessageConverter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Component
public class SenderService {

    private static final Logger log = LoggerFactory.getLogger( SenderService.class );
    private final KafkaTemplate<String, byte[]> sensorKafkaTemplate;
    private final AvroSchemaRegistryClientMessageConverter converter;

    private final String topic;

    SenderService(
            final KafkaTemplate<String, byte[]> sensorKafkaTemplate,
            final AvroSchemaRegistryClientMessageConverter converter,
            @Value( "${spring.kafka.template.default-topic}") final String topic
    ) {

        this.sensorKafkaTemplate = sensorKafkaTemplate;
        this.converter = converter;
        this.topic = topic;

    }

    public void emitSensor() {

        var sensorId = "spring-kafka-" + UUID.randomUUID();
        var random = new Random();

        var sensor = new Sensor( sensorId, random.nextFloat(), random.nextFloat(), random.nextFloat() );
        var message =
                this.converter.toMessage( sensor, new MessageHeaders(
                        Map.of(
                                KafkaHeaders.TOPIC, this.topic
                        )
                ));

        assert message != null;
        this.sensorKafkaTemplate.send( message );
        log.info( "Sensor [{}] sent!", sensor );

    }

}
