package com.bigbearai.datacollection.weatherdataservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BluewaterFeignClient implements BluewaterClient{

    @Autowired
    private BluewaterFeignClientInterface bluewaterFeignClient;

    @Override
    public String getHelloWorld() {
        return bluewaterFeignClient.getHelloWorld()+" through FEIGN Client";
    }

    @Override
    public String getHelloWorldFrom(String name) {
        return bluewaterFeignClient.getHelloWorldFrom(name)+" through FEIGN Client";
    }
}
