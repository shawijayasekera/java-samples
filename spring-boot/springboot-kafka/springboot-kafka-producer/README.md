# Springboot Kafka Producer

## Create topic

bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test_springboot_kafka_producer_user_topic

## Create consumer to listen topic

bin/windows/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test_springboot_kafka_producer_user_topic --from-beginning
