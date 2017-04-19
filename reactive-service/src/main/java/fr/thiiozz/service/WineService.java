package fr.thiiozz.service;

import fr.thiiozz.model.MongoWine;
import fr.thiiozz.model.Wine;
import fr.thiiozz.repository.ReactiveWineRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class WineService {
    private ReactiveWineRepository reactiveWineRepository;

    public WineService(ReactiveWineRepository reactiveWineRepository){
        this.reactiveWineRepository = reactiveWineRepository;
    }

    public Flux<MongoWine> getWines(){
        return  reactiveWineRepository.findAll()
                .delayElements(Duration.ofSeconds(3))
                .log();
    }

    public Flux<String> getWinesCheaperThan(String maxPrice) {
        float maximumPrice = Float.valueOf(maxPrice);

        return reactiveWineRepository.findAll()
                .distinct()
                .filter(w -> w.getPrice() <= maximumPrice)
                .map(Wine::getName);
    }

    public Mono<Long> getNumberOfBottles() {
        return reactiveWineRepository.findAll()
                .count();
    }
}
