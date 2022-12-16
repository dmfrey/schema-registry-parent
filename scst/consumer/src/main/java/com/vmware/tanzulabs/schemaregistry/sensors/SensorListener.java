package com.vmware.tanzulabs.schemaregistry.sensors;

import com.vmware.tanzulabs.schemaregistry.records.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class SensorListener {

    private static final Logger log = LoggerFactory.getLogger( SensorListener.class );

    @Bean
    public Consumer<Sensor> sensors() {

        return sensor -> log.info( "Sensor [{}] received!", sensor );
    }
}
