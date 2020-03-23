package com.example.apigetter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Marcos Barbero
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.example.apigetter.entities.config",
        mongoTemplateRef = ConfigMongoTemplate.MONGO_TEMPLATE)
public class ConfigMongoTemplate {

    protected static final String MONGO_TEMPLATE = "configMongoTemplate";
}
