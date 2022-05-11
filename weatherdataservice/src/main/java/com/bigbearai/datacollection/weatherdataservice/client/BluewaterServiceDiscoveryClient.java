package com.bigbearai.datacollection.weatherdataservice.client;

import com.bigbearai.datacollection.weatherdataservice.BlueWaterDataDiscoveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BluewaterServiceDiscoveryClient implements BluewaterClient{

    Logger logger = LoggerFactory.getLogger(BluewaterServiceDiscoveryClient.class);


    @Autowired
    private DiscoveryClient discoveryClient;

    public String getHelloWorld(){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("BLUEWATERDATASERVICE");
        String s = instances.get(0).getUri().toString();
        logger.info("getUri: "+s);
        if (instances.size()==0) return null;
        String serviceUri = String.format("%s/helloworld",instances.get(0).getUri().toString());//, null);

        ResponseEntity< String > restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.GET,
                        null, String.class);

        return restExchange.getBody()+" through DiscoveryClient";
    }

    public String getHelloWorldFrom(String name){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("BLUEWATERDATASERVICE");
        String s = instances.get(0).getUri().toString();
        logger.info("getUri: "+s);
        if (instances.size()==0) return null;
        String serviceUri = String.format("%s/helloworld/%s",instances.get(0).getUri().toString(), name);

        ResponseEntity< String > restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.GET,
                        null, String.class);

        return restExchange.getBody()+" through DiscoveryClient";
    }

}
