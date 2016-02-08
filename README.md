Twitter Kafka Connect
=====================

Sources tweets from the Twitter streaming API; places them into Kafka.

    Twitter -> [twitter-kafka-connect] -> Kafka

Development is in progress. Just for illustration purposes, tons of hardcoded constants, no resume on fail, not production ready, you get it...

 - Follow [Confluent quick start](http://docs.confluent.io/2.0.0/quickstart.html);
 - Derive your own `.properties` from `twitter-source.properties.example`;
 - Then start another two terminals with:

```shell
$ connect-standalone /etc/kafka/connect-standalone.properties twitter-source.properties  
$ kafka-console-consumer --zookeeper localhost:2181 --topic topic
```
... to watch Twitter streaming events come by as JSON.

