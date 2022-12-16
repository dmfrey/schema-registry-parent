package com.vmware.tanzulabs.schemaregistry.config;

import org.springframework.cloud.stream.schema.registry.client.EnableSchemaRegistryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSchemaRegistryClient
public class KafkaConfig {

//    @Value( value = "${spring.kafka.bootstrap-servers}" )
//    private String bootstrapAddress;
//
//    @Bean
//    public KafkaAdmin kafkaAdmin( AvroSerializer avroSerializer ) {
//
//        var configs = new HashMap<String, Object>();
//        configs.put( AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress );
//        configs.put( "schema.registry.url", "http://localhost:8990" );
//        configs.put( "key.serializer", StringSerializer.class );
//        configs.put( "value.serializer", avroSerializer );
//
//        return new KafkaAdmin(configs);
//    }

}
