package com.vmware.tanzulabs.schemaregistry.sensors;

import com.vmware.tanzulabs.schemaregistry.records.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class SensorListener {

    private static final Logger log = LoggerFactory.getLogger( SensorListener.class );

    @KafkaListener( topics = { "sensors-5" } )
    void sensors( Message<Sensor> sensor ) {

        log.info( "Sensor [{}] received!", sensor.getPayload() );

    }

}
