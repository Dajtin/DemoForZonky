package com.roman.demo.webapi.controlers;


import com.roman.demo.webapi.models.WebPushSubscription;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.roman.demo.webapi.services.WebService.subscriptions;

@RestController
public class SubscribeController {

    /**
     * make connection with subscriber
     */

    @PostMapping("/subscribe")
    public void subscribe(WebPushSubscription subscription) {
        subscriptions.put(subscription.getNotificationEndPoint(), subscription);
    }
    /**
     * remove connection with subscriber
     */
    @PostMapping("/unsubscribe")
    public void unsubscribe(WebPushSubscription subscription) {
        subscriptions.remove(subscription.getNotificationEndPoint());
    }

}
