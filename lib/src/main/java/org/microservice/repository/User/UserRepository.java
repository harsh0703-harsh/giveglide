package org.microservice.repository.User;
import org.microservice.models.UserModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<UserModel,String> {

    UserModel findByEmail(String email);
    UserModel findByEmailAndGuestCheckout(String email, Boolean guestCheckout);
    UserModel findByEmailAndVerificationCode(String email , Integer verificationCode);

}
