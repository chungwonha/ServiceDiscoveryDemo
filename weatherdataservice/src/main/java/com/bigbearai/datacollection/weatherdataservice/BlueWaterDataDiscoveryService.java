package com.bigbearai.datacollection.weatherdataservice;

import com.bigbearai.datacollection.weatherdataservice.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BlueWaterDataDiscoveryService {

    Logger logger = LoggerFactory.getLogger(BlueWaterDataDiscoveryService.class);

    @Autowired
    private BluewaterRestTemplateClient bluewaterRestTemplateClient;

    @Autowired
    private BluewaterFeignClient bluewaterFeignClient;

    @Autowired
    private BluewaterServiceDiscoveryClient bluewaterServiceDiscoveryClient;

    public BluewaterClient getBluewaterClient(String clientType) {
        if(clientType.equals("REST")){
            return bluewaterRestTemplateClient;
        }else if(clientType.equals("DISCOVERY")){
            return bluewaterServiceDiscoveryClient;
        }else if(clientType.equals("FEIGN")){
            return bluewaterFeignClient;
        }
        return null;
    }

    public String getHelloWorld(String clientType){
        BluewaterClient bluewaterClient = this.getBluewaterClient(clientType);
        return bluewaterClient.getHelloWorld();
    }

    public String getHelloWorld(String clientType,String name){
        BluewaterClient bluewaterClient = this.getBluewaterClient(clientType);
        return bluewaterClient.getHelloWorldFrom(name);
    }

}
