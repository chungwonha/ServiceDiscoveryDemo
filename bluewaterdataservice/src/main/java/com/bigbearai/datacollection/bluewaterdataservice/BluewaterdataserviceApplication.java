package com.bigbearai.datacollection.bluewaterdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class BluewaterdataserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluewaterdataserviceApplication.class, args);
	}

}
