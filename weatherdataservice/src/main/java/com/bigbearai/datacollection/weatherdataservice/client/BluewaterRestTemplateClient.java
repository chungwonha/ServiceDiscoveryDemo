package com.bigbearai.datacollection.weatherdataservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BluewaterRestTemplateClient implements BluewaterClient {

    @Autowired
    RestTemplate restTemplate;

    public String getHelloWorld(){
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://BLUEWATERDATASERVICE/helloworld",
                        HttpMethod.GET,
                        null, String.class);

        return restExchange.getBody()+" through the enhanced RestTemplate";
    }

    public String getHelloWorldFrom(String name){
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://BLUEWATERDATASERVICE/helloworld/{name}",
                        HttpMethod.GET,
                        null, String.class,name);

        return restExchange.getBody()+" through the enhanced RestTemplate";
    }

}
