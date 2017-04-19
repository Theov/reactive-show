package fr.thiiozz;

import fr.thiiozz.service.MongoFeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Collections;

@SpringBootApplication
public class MongoFeederApplication implements CommandLineRunner {

    @Autowired
    private MongoFeederService mongoFeederService;

    public static void main(String[] args){
        new SpringApplicationBuilder(MongoFeederApplication.class)
                .properties(Collections.singletonMap("server.port", 8082))
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        mongoFeederService.runDaemon();
    }
}
