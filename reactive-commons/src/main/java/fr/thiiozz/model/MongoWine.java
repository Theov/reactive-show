package fr.thiiozz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wine")
public class MongoWine extends Wine{
    @Id
    private String id;

    public MongoWine(){

    }

    public MongoWine(String name, int year, int price){
        super(name, year, price);
    }

    @Override
    public String toString() {
        return "MongoWine{" +
                "id='" + id + '\'' +
                '}';
    }
}

