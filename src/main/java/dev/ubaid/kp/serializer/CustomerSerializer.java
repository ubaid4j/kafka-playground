package dev.ubaid.kp.serializer;

import dev.ubaid.kp.dto.Customer;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CustomerSerializer implements Serializer<Customer> {

    @Override
    public byte[] serialize(String topic, Customer data) {
        try {
            byte[] serializedName;
            int stringSize;
            if (data == null) {
                return null;
            } else {
                if (data.customerName() != null) {
                    serializedName = data.customerName().getBytes(StandardCharsets.UTF_8);
                    stringSize = serializedName.length;
                } else {
                    serializedName = new byte[0];
                    stringSize = 0;
                }
            }

            ByteBuffer buffer = ByteBuffer.allocate(4+4+stringSize);
            buffer.putInt(data.customerId());
            buffer.putInt(stringSize);
            buffer.put(serializedName);
            
            return buffer.array();
        } catch(Exception ex) {
            throw new SerializationException("Error when serializing customer to byte[]", ex);
        }
    }
}
