package com.roman.demo.webapi.schedulers;


import com.roman.demo.webapi.models.Loan;
import com.roman.demo.webapi.models.WebPushMessage;
import com.roman.demo.webapi.controlers.RestConsumer;
import com.roman.demo.webapi.services.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.roman.demo.webapi.DemoApplication.MESSAGES_NEW_LOAN;
import static com.roman.demo.webapi.DemoApplication.SHOW_NOTIFICATION_SECONDS;
import static com.roman.demo.webapi.DemoApplication.WAIT_TASK_MINUTES;


@Component
public class Task {
    private static final Logger LOGGER = Logger.getLogger(Task.class.getName());
    @Autowired
    private DateService dateService;
    @Autowired
    private WebService webService;

    /**
     * scheduled task which perform filtering loans and sending notifications
     * task are performed in intervals WAIT_TASK_MINUTES
     * more notifications are show in intervals SHOW_NOTIFICATION_SECONDS
     */
    @Scheduled(fixedRate = (WAIT_TASK_MINUTES * 60000))
    public void task() {
        getLoans().forEach(
                item ->
                {
                    LOGGER.log(Level.FINE, "DEBUG    " + item.getId() + "      " + item.getUrl());
                    webService.sendMessages(new WebPushMessage(
                                    item.getId(),
                                    item.getUrl(),
                                    String.format(MESSAGES_NEW_LOAN,
                                            item.getRevenueRate() * 100,
                                            item.getRating(),
                                            item.getRemainingInvestment())
                            )
                    );
                    try {
                        Thread.sleep(SHOW_NOTIFICATION_SECONDS * 1000);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
        );

    }


    /**
     * filter loans which was published = now - WAIT_TASK_MINUTES
     *
     * @return list of Loans
     */

    private List<Loan> getLoans() {
        return RestConsumer
                .getLoans()
                .stream()
                .filter(item ->
                        item.getDatePublished()
                                .compareTo(dateService.calculatedDate(WAIT_TASK_MINUTES)) > 0)
                .collect(Collectors.toList());
    }
}
