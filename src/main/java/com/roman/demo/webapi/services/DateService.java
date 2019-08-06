package com.roman.demo.webapi.services;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class DateService {

    /**
     * get present date (2019-08-04 17:54:48.353) minus specified minutes
     *
     * @param substractMinutes
     * @return  Date - substractMinutes
     */
    public Date calculatedDate(long substractMinutes) {
        LocalDateTime dateTime = LocalDateTime.now().minus(Duration.of(substractMinutes, ChronoUnit.MINUTES));
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

    }
}
