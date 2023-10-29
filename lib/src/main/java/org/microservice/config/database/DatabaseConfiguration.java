package org.microservice.config.database;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class DatabaseConfiguration {


    @Value("${spring.data.mongodb.user.uri}")
    private String userMongoUri;

    @Value("${spring.data.mongodb.charity.uri}")
    private String charityMongoUri;



    @Primary
    @Bean(name = "userMongoTemplate")
    public MongoTemplate userMongoTemplate() throws Exception{

        return new MongoTemplate(userMongoDatabaseFactory());

    }

    @Bean(name = "charityMongoTemplate")
    public MongoTemplate charityMongoTemplate() throws Exception{

        return new MongoTemplate(charityMongoDatabaseFactory());

    }

    @Primary
    @Bean
    public MongoDatabaseFactory userMongoDatabaseFactory() throws Exception{

        return new SimpleMongoClientDatabaseFactory(
                userMongoUri
        );

    }

    @Bean
    public MongoDatabaseFactory charityMongoDatabaseFactory() throws Exception{

        return new SimpleMongoClientDatabaseFactory(
                charityMongoUri
        );

    }
}
