package com.roman.demo.webapi.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateServiceTests {

    @Resource
    private DateService dateService;


    @Test
    public void dateServiceTest() {
        assertEquals(dateService.calculatedDate(0).getTime(), new Date().getTime(),1);
        assertNotEquals(dateService.calculatedDate(5), new Date());
    }
}
