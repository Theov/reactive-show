package fr.thiiozz;

import fr.thiiozz.model.Wine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@SpringBootApplication
public class ReactiveApplicationClient {
	@Bean
	WebClient client (){
		return WebClient.create("http://localhost:8080");
	}

	@Bean
	CommandLineRunner demon (WebClient client){
		return  args -> {
			client
					.get()
					.uri("/wines")
					.accept(MediaType.TEXT_EVENT_STREAM)
					.exchange()
					.flatMapMany(cr -> cr.bodyToFlux(Wine.class))
					.repeat()
					.subscribe(Wine::display);
		};
	}



	public static void main(String[] args){
		new SpringApplicationBuilder(ReactiveApplicationClient.class)
				.properties(Collections.singletonMap("server.port", 8081))
				.run(args);
	}
}
