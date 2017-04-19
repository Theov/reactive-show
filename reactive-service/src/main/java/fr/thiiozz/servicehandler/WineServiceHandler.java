package fr.thiiozz.servicehandler;

import fr.thiiozz.model.MongoWine;
import fr.thiiozz.service.WineService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class WineServiceHandler {
    private final WineService wineService;

    public WineServiceHandler(WineService wineService) {
        this.wineService = wineService;
    }

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions
                .route(GET("/wines"), this::fetchWineFlux)
                .andRoute(GET("/wine/counter"), this::fetchLastWine)
                .andRoute(GET("/wines/{maxPrice}"), this::fetchWineFluxFilteredByPrice);
    }

    private Mono<ServerResponse> fetchWineFluxFilteredByPrice(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(wineService.getWinesCheaperThan(serverRequest.pathVariable("maxPrice")), String.class);
    }

    private Mono<ServerResponse> fetchWineFlux(ServerRequest serverRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccessControlAllowOrigin("*");

        return ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .headers(headers)
                .body(wineService.getWines(), MongoWine.class);
    }

    private Mono<ServerResponse> fetchLastWine(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(wineService.getNumberOfBottles(), Long.class);
    }
}
