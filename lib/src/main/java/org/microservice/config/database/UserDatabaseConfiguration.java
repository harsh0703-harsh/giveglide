package org.microservice.config.database;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {
        "org.microservice.repository.User"
},
        mongoTemplateRef = UserDatabaseConfiguration.MONGO_TEMPLATE
)
public class UserDatabaseConfiguration {

    protected static final String MONGO_TEMPLATE= "userMongoTemplate";
}
