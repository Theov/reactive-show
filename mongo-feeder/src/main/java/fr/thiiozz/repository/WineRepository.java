package fr.thiiozz.repository;


import fr.thiiozz.model.MongoWine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WineRepository extends MongoRepository<MongoWine, Long> {

}
