package org.microservice.config.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {
        "org.microservice.repository.Charity"
},
        mongoTemplateRef = CharityDatabaseConfiguration.MONGO_TEMPLATE
)
public class CharityDatabaseConfiguration {

    protected static final String MONGO_TEMPLATE = "charityMongoTemplate";

}
