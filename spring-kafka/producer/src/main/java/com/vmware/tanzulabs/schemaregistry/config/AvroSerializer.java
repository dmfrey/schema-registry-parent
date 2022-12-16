package com.vmware.tanzulabs.schemaregistry.config;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.messaging.Message;
import org.springframework.cloud.stream.schema.registry.avro.AvroSchemaRegistryClientMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class AvroSerializer<T extends SpecificRecordBase> implements Serializer<T> {

    private AvroSchemaRegistryClientMessageConverter converter;

    public AvroSerializer( final AvroSchemaRegistryClientMessageConverter converter ) {

        this.converter = converter;

    }

    @Override
    public byte[] serialize( String topic, T data ) {

        Message<?> m = this.converter.toMessage( data, null );

        assert m != null;
        return (byte[]) m.getPayload();
    }

}
