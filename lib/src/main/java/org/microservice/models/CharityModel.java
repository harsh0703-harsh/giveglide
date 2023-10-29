package org.microservice.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "charities")
@Data
@NoArgsConstructor
public class CharityModel {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;

    private String email ;

    private  String type;

    public String country;
    public  String regno;
    public  String name;
    public  String website;
    public  Object address;
    public  Boolean active ;
    public  Boolean verified ;

    public CharityModel(

            ObjectId _id,
            String type,
            String country,
            String regno,
            String name,
            String website,
            Object address,
            Boolean active,
            Boolean verified

    ){
        this._id = _id ;
        this.type = type;
        this.country = country;
        this.regno = regno;
        this.name = name;
        this.website = website;
        this.address = address;
        this.active = active;
        this.verified = verified;
    }

    public void setActive( Boolean value){

        this.active = value;

    }

    public void setVerified( Boolean value){

        this.verified = value;

    }

}
