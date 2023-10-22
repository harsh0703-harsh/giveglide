package org.microservice.repository;
import org.microservice.models.UserModel;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<UserModel,String> {

    UserModel findByEmail(String email);

}
