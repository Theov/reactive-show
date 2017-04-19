package fr.thiiozz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReactiveApplicationClientTest {

    private WebTestClient webTestClient;

    @Before
    public void before(){
        this.webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    public void eventById() throws Exception{
        this.webTestClient.get()
                .uri("wines")
                .exchange()
                .expectStatus().isOk();
    }
}
