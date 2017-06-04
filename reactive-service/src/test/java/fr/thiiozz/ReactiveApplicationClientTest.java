package fr.thiiozz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReactiveApplicationClientTest {

    private WebTestClient webTestClient;

    @Before
    public void before(){
        this.webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    public void getWineTest() throws Exception{
        this.webTestClient.get()
                .uri("wines")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void reactorIntroduction(){
        Mono<String> mono = Mono.just("Hello World !");
        mono.subscribe(System.out::println);

        String[] arr = {"The", "quick", "brown", "fox", "jump", "over", "the", "lazy", "dog"};

        Flux<String> flux = Flux.fromIterable(Arrays.asList(arr));
        flux.subscribe(System.out::println);
    }


}
