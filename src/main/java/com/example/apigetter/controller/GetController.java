package com.example.apigetter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController("/")
public class GetController {

    private static Logger log = LoggerFactory.getLogger(GetController.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public String hello() {

        String a = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", String.class);
        log.info("data fetched : " + a);
        return a;
    }
}
