package com.roman.demo.webapi.models;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanTests {
    Loan loan = new Loan();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");


    @Test
    public void loanObjectTest() throws Exception {
        String dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);
        loan.setId("idABC");
        loan.setRating("ABC");
        loan.setDatePublished(date);
        loan.setRevenueRate(0.052);
        loan.setUrl("www.google.com");
        loan.setRemainingInvestment(1000);

        assertEquals("idABC", loan.getId());
        assertEquals("ABC", loan.getRating());
        assertEquals(date, loan.getDatePublished());
        assertEquals(0.052, loan.getRevenueRate(), 0);
        assertEquals("www.google.com", loan.getUrl());
        assertEquals(1000, loan.getRemainingInvestment(), 0);
        assertEquals("idABC, www.google.com, ABC, Tue Aug 31 10:20:56 CEST 1982, 0, 0.052", loan.toString());
    }

}
