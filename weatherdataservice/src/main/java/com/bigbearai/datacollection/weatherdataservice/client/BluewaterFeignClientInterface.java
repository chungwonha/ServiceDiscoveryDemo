package com.bigbearai.datacollection.weatherdataservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("BLUEWATERDATASERVICE")
public interface BluewaterFeignClientInterface extends BluewaterClient {

    @RequestMapping(method= RequestMethod.GET,
                    value="/helloworld")
    String getHelloWorld();

    @RequestMapping(method= RequestMethod.GET,
            value="/helloworld/{name}")
    String getHelloWorldFrom(@PathVariable("name") String name);

}
