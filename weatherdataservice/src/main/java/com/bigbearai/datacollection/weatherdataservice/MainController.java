package com.bigbearai.datacollection.weatherdataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/weatherdataservice")
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    BlueWaterDataDiscoveryService blueWaterDataDiscoveryService;

    @GetMapping("/helloworld")
    public String getHelloWorld(){

        logger.info("Hello World from Weather Data MainController!");
        return "Hello World from Weather Data MainController!";
    }

    @GetMapping("/helloworldfrombluewater/{clientType}")
    public String getHelloWorldFromBlueWater(@PathVariable String clientType){
        String s = blueWaterDataDiscoveryService.getHelloWorld(clientType);
        logger.info(s);
        return s;
    }

    @GetMapping("/helloworldfrombluewater/{clientType}/{name}")
    public String getHelloWorldFromBlueWaterName(@PathVariable String clientType,
                                                 @PathVariable String name){
        String s = blueWaterDataDiscoveryService.getHelloWorld(clientType,name);
        logger.info(s);
        return s;
    }
}
