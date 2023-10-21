package org.microservice.repositories;
import org.microservice.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<UserModel,String> {

}
