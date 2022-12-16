package com.vmware.tanzulabs.schemaregistry.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import com.vmware.tanzulabs.schemaregistry.records.Sensor;
import org.springframework.util.MimeType;

import java.util.Random;
import java.util.UUID;

@Component
public class SenderService {

    private static final Logger log = LoggerFactory.getLogger( SenderService.class );
    private final StreamBridge streamBridge;

    SenderService( final StreamBridge streamBridge ) {

        this.streamBridge = streamBridge;

    }

    public void emitSensor() {

        var sensorId = "scst-" + UUID.randomUUID();
        var random = new Random();

        var sensor = new Sensor( sensorId, random.nextFloat(), random.nextFloat(), random.nextFloat() );

        this.streamBridge.send( "sensors-out-0", sensor, MimeType.valueOf( "application/+avro" ) );
        log.info( "Sensor [{}] sent!", sensor );

    }

}
