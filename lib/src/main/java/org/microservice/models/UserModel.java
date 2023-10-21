package org.microservice.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Builder
public class UserModel {

    @Id
    private ObjectId _id;
    private String first_name;
    private String last_name;
    private String email;

}
