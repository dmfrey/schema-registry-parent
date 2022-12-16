package com.vmware.tanzulabs.schemaregistry.sender;

import com.vmware.tanzulabs.schemaregistry.records.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.schema.registry.avro.AvroSchemaRegistryClientMessageConverter;
import org.springframework.kafka.core.KafkaTemplate;
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

    SenderService( final KafkaTemplate<String, byte[]> sensorKafkaTemplate, final AvroSchemaRegistryClientMessageConverter converter ) {

        this.sensorKafkaTemplate = sensorKafkaTemplate;
        this.converter = converter;

    }

    public void emitSensor() {

        var sensorId = "spring-kafka-" + UUID.randomUUID();
        var random = new Random();

        var sensor = new Sensor( sensorId, random.nextFloat(), random.nextFloat(), random.nextFloat() );
        var message = this.converter.toMessage( sensor, new MessageHeaders( Map.of() ) );

        assert message != null;
        this.sensorKafkaTemplate.send( "sensors-2", sensor.getId().toString(), ( (byte[]) message.getPayload() ) );
        log.info( "Sensor [{}] sent!", sensor );

    }

}
