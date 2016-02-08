package com.github.rollulus.twitterconnect;

import org.apache.kafka.common.utils.AppInfoParser;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterSourceConnector extends SourceConnector {
    public static final String TOPIC_CONFIG = "topic";
    public static final String CONSUMERKEY_CONFIG = "twitter.consumerkey";
    public static final String CONSUMERSECRET_CONFIG = "twitter.consumersecret";
    public static final String TOKEN_CONFIG = "twitter.token";
    public static final String SECRET_CONFIG = "twitter.secret";

    private static final Logger log = LoggerFactory.getLogger(TwitterSourceTask.class);

    private String consumerkey;
    private String consumersecret;
    private String token;
    private String secret;

    @Override
    public String version() {
        return AppInfoParser.getVersion();
    }

    @Override
    public void start(Map<String, String> props) {
        log.info("start");
        consumerkey = props.get(CONSUMERKEY_CONFIG);
        consumersecret = props.get(CONSUMERSECRET_CONFIG);
        token = props.get(TOKEN_CONFIG);
        secret = props.get(SECRET_CONFIG);
    }

    @Override
    public Class<? extends Task> taskClass() {
        return TwitterSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        log.info("cfgs");
        ArrayList<Map<String, String>> configs = new ArrayList<>();
        Map<String, String> config = new HashMap<>();
        config.put(CONSUMERKEY_CONFIG, consumerkey);
        config.put(CONSUMERSECRET_CONFIG, consumersecret);
        config.put(TOKEN_CONFIG, token);
        config.put(SECRET_CONFIG, secret);
        configs.add(config);
        return configs;
    }

    @Override
    public void stop() {
    }
}
