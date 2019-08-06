package com.roman.demo.webapi.controlers;

import com.roman.demo.webapi.models.Loan;
import com.roman.demo.webapi.DemoApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class RestConsumer {
    /**
     * consumer for zonky api which map Json to object Loan
     * consumer select only loans from today
     * @return List of Loan
     */

    public static List<Loan> getLoans() {
        ResponseEntity<Loan[]> responseEntity = new RestTemplate()
                .getForEntity(
                        DemoApplication.URL.replaceAll("placeholder", new Date().toString()),
                        Loan[].class
                );
        Loan[] loans = responseEntity.getBody();
        return Arrays.asList(loans);
    }
}
