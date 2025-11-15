package com.jakepasternak.multi_vendor_marketplace.apiDocs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/debug")
public class DocsDebugController {

    private final WebClient.Builder webClientBuilder;

    public DocsDebugController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/auth-docs")
    public Mono<String> debugAuthDocs() {
        return webClientBuilder.build()
                .get()
                .uri("lb://auth-service/v3/api-docs")
                .exchangeToMono(response -> {
                    System.out.println("Status: " + response.statusCode());
                    return response.bodyToMono(String.class)
                            .doOnNext(body -> System.out.println("Response Body: " + body));
                });
    }
}
