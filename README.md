# sb-kafka <br>
ZooKeeper/Kafka Commands: <br>
------------------------- <br>
export KAFKA_HOME=~/dev/tools/kafka_2.13-3.9.0 <br>
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties <br>
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties <br>
$KAFKA_HOME/bin/kafka-topics.sh --list --bootstrap-server localhost:9092 <br>
$KAFKA_HOME/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic message-topic <br>
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic message-topic --from-beginning <br>
$KAFKA_HOME/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic message-topic <br>
$KAFKA_HOME/bin/kafka-configs.sh --bootstrap-server localhost:9092 --entity-type topics --describe <br>
$KAFKA_HOME/bin/kafka-configs.sh --bootstrap-server localhost:9092 --entity-type topics --entity-name message-topic --describe <br>
cat message-topic-file.txt | $KAFKA_HOME/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic message-topic <br>
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic message-topic --partitions 2 <br>
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic message-topic  <br>
$KAFKA_HOME/bin/kafka-server-stop.sh $KAFKA_HOME/config/server.properties <br>
$KAFKA_HOME/bin/zookeeper-server-stop.sh stop $KAFKA_HOME/config/zookeeper.properties <br>


CURL command to post message: curl -i -H "Content-Type: application/json" -H "Accept: application/json" --data '{"id": 100, "title":"title1"}' -X POST http://localhost:8080/api/publish <br>
