#!/bin/bash
# Ждём пока Kafka будет готова
sleep 10
docker exec kafka_kafka_1 kafka-topics.sh --create --topic topic-1 --bootstrap-server kafka:9092 --partitions 1 --replication-factor 1
docker exec kafka_kafka_1 kafka-topics.sh --create --topic topic-2 --bootstrap-server kafka:9092 --partitions 1 --replication-factor 1
