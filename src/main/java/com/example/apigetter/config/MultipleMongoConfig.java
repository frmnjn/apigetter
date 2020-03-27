package com.example.apigetter.config;

import com.mongodb.MongoClientURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MultipleMongoConfig {

    private static Logger log = LoggerFactory.getLogger(MultipleMongoConfig.class);

    @Primary
    @Bean(name = "configTemplate")
    @ConfigurationProperties(prefix = "mongodb.config")
    public MongoProperties getConfigTemplate() {
        return new MongoProperties();
    }

    @Bean(name = "reportTemplate")
    @ConfigurationProperties(prefix = "mongodb.report")
    public MongoProperties getReportTemplate() {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = ConfigMongoTemplate.MONGO_TEMPLATE)
    public MongoTemplate configMongoTemplate() throws Exception {
        return new MongoTemplate(configFactory(getConfigTemplate()));
    }

    @Bean(name = ReportMongoTemplate.MONGO_TEMPLATE)
    public MongoTemplate reportMongoTemplate() throws Exception {
        return new MongoTemplate(reportFactory(getReportTemplate()));
    }

    @Bean
    @Primary
    public MongoDbFactory configFactory(final MongoProperties mongo) throws Exception {
        MongoClientURI uri = new MongoClientURI(mongo.getUri());
//        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),mongo.getDatabase());
        return new SimpleMongoDbFactory(uri);
    }

    @Bean
    public MongoDbFactory reportFactory(final MongoProperties mongo) throws Exception {
        MongoClientURI uri = new MongoClientURI(mongo.getUri());
        //return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),mongo.getDatabase());
        return new SimpleMongoDbFactory(uri);
    }
}
