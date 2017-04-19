package fr.thiiozz.repository;

import fr.thiiozz.model.MongoWine;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveWineRepository extends ReactiveCrudRepository<MongoWine, Long> {
}
