package com.vmware.tanzulabs.schemaregistry.sensors;

import com.vmware.tanzulabs.schemaregistry.records.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.schema.registry.avro.AvroSchemaRegistryClientMessageConverter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class SensorListener {

    private static final Logger log = LoggerFactory.getLogger( SensorListener.class );

    private AvroSchemaRegistryClientMessageConverter converter;

    public SensorListener( final AvroSchemaRegistryClientMessageConverter converter ) {

        this.converter = converter;

    }

    @KafkaListener( topics = { "${spring.kafka.template.default-topic}" } )
    void sensors( Message<byte[]> message ) {

        var sensor = this.converter.fromMessage( message, Sensor.class );
        log.info( "Sensor [{}] received!", sensor );

    }

}
