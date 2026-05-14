package com.example.homerodoh.service;

import com.example.homerodoh.dto.QuoteDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class QuotesService {

    private final WebClient webClient;

    public QuotesService(WebClient webClient) {
        this.webClient = webClient;
    }

    public QuoteDTO getRandomQuote() {

        return webClient
                .get()
                .uri("https://dummyjson.com/quotes/random")
                .retrieve()
                .bodyToMono(QuoteDTO.class)
                .block();
    }
}