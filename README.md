Twitter Kafka Connect
=====================

Sources tweets from the Twitter streaming API; places them into Kafka.

    Twitter -> [twitter-kafka-connect] -> Kafka

Development is in progress, this might serve only for illustration purposes. 

No tests. Tons of hardcoded constants. No resume on fail. 

 - Follow [Confluent quick start](http://docs.confluent.io/2.0.0/quickstart.html);
 - Derive your own `.properties` from `twitter-source.properties.example`;
 - Then start another two terminals with:

```shell
$ connect-standalone connect-standalone.properties twitter-source.properties  
$ kafka-avro-console-consumer --topic topic --zookeeper localhost:2181
```
... to watch Twitter streaming events come by as JSON.

Contributions are welcome, thanks!
