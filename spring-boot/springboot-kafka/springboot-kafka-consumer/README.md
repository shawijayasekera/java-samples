# Springboot Kafka Consumer

## Create topic

bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test_springboot_kafka_producer_string_topic

bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test_springboot_kafka_producer_user_topic

## Create producer to send messages to topic

bin/windows/kafka-console-producer.bat --broker-list localhost:9092 --topic test_springboot_kafka_producer_string_topic

bin/windows/kafka-console-producer.bat --broker-list localhost:9092 --topic test_springboot_kafka_producer_user_topic