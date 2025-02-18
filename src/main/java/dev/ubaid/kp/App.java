package dev.ubaid.kp;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
    
    static Logger log = LoggerFactory.getLogger(App.class);
    
    public static void main( String[] args ) throws InterruptedException {

        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(kafkaProps);

        ProducerRecord<String, String> record = new ProducerRecord<>("cutsomer-country", "Precision Products", "France");
        
        try {
            kafkaProducer.send(record);
        } catch (Exception e) {
            log.error("error: ", e);
            throw new RuntimeException(e);
        }


        ProducerRecord<String, String> record2 = new ProducerRecord<>("cutsomer-country","Precision Products", "Germany");

        try {
            RecordMetadata metadata = kafkaProducer.send(record2, (metadata_, exp_) -> {
                log.error("{} is not sent. Error: ", metadata_, exp_);
            }).get();
            log.info("message sent, meta data: {}", metadata.toString());
        } catch (Exception e) {
            log.error("error: ", e);
            throw new RuntimeException(e);
        }


        Thread.sleep(Duration.ofSeconds(20));
    }
    
    
}
