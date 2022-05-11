package com.bigbearai.datacollection.bluewaterdataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/helloworld")
    public String getHelloWorld(){
        logger.info("Hello World from Bluewater main controller!");
        return "Hello World from Bluewater main controller!";
    }

    @GetMapping("/helloworld/{name}")
    public String getGetHelloWorldName(@PathVariable String name){
        return "Hello world! This is from "+name+" in Blue Water";
    }
}
