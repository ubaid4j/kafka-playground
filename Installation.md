## Installing Kafka Natively in Linux

### Installing Kafka
1. Download Latest Apache Kafka tar: https://kafka.apache.org/downloads.html
2. Move unziped to `/usr/local/kafka`
3. `cd /usr/local/kafak`
4. `bin/zookeeper-server-start.sh config/zookeeper.properties`
3. `bin/kafka-server-start.sh config/server.properties`
#### Important directories
1. configurations: `/usr/local/kafka/config`
2. Logs: `/usr/local/kafka/logs`