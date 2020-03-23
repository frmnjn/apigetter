package com.example.apigetter.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CollectAppManager {

    private static Logger logger = LoggerFactory.getLogger(CollectAppManager.class);

    @Autowired
    @Qualifier("reportMongoTemplate")
    private MongoTemplate reportMongoTemplate;

    @Autowired
    @Qualifier("configMongoTemplate")
    private MongoTemplate configMongoTemplate;

}
