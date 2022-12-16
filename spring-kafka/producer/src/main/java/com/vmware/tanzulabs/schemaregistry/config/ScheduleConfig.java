package com.vmware.tanzulabs.schemaregistry.config;

import com.vmware.tanzulabs.schemaregistry.sender.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Autowired
    SenderService senderService;

    @Scheduled( fixedRate = 5000 )
    void sensorSchedule() {

        senderService.emitSensor();

    }

}
