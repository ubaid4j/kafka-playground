### Kafka:
Publish/subscribe messaging system.

### Zookeepr:
Apache Kafka uses Apache ZooKeeper to store metadata about the Kafka cluster, as well as consumer client details.

### Topics
Topic is like database table to store the document. 
#### Create Topic
```
bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --replication-factor 1 -partitions 1 --topic test
```
#### View Topic
```
bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic test
```

### Produce Message
```
bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test
```

### Consume Message
```
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
```