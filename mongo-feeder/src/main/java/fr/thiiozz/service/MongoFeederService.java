package fr.thiiozz.service;

import fr.thiiozz.repository.WineRepository;
import fr.thiiozz.utils.WineGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class MongoFeederService {
    private final static int INSERT_SECOND_INTERVAL = 5;
    private final static  Logger logger = LoggerFactory.getLogger(MongoFeederService.class);

    private WineRepository wineRepository;

    public MongoFeederService(WineRepository wineRepository){
        this.wineRepository = wineRepository;
    }

    public void runDaemon() throws Exception {
        flushCollection();

        while(true){
            insert();
            logger.info("Row inserted");
            Thread.sleep((INSERT_SECOND_INTERVAL * 1000));
        }
    }

    private void flushCollection() {
        wineRepository.deleteAll();
    }

    private void insert() {
        wineRepository.insert(WineGenerator.generateAndGetWine());
    }
}