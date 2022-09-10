package com.bigbearai.datacollection.bluewaterdataservice;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

@RestController
@ConfigurationProperties(prefix = "bluewaterdataservice")
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    String message;

    @GetMapping("/messagefromconfigserver")
    public String getGetHelloWorldName(){
        return this.message;
    }

    @GetMapping("/helloworld")
    public String getHelloWorld(){
        logger.info("Hello World from Bluewater main controller!");
        return "Hello World from Bluewater main controller!";
    }

    @GetMapping("/helloworld/{name}")
    public String getGetHelloWorldName(@PathVariable String name){
        return "Hello world! This is from "+name+" in Blue Water";
    }

    @GetMapping("/getcsv")
    public String getCsv(){
        String fileName = "c:\\temp\\online-jobposting1.csv";
        List<String[]> r;

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            r = reader.readAll();
        }catch(IOException ioException){
            ioException.printStackTrace();
            return "failed";
        }catch (CsvException csve){
            csve.printStackTrace();
            return "failed";
        }
    System.out.println("size: "+r.size());
        int listIndex = 0;
        for (String[] arrays : r) {
            System.out.println("\nString[" + listIndex++ + "] : " + Arrays.toString(arrays));

            int index = 0;
            for (String array : arrays) {
                System.out.println(index++ + " : " + array);
            }

        }

    return "done";
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
