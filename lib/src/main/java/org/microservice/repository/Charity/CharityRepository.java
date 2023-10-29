package org.microservice.repository.Charity;

import org.microservice.models.CharityModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharityRepository extends MongoRepository<CharityModel,String> {

}
