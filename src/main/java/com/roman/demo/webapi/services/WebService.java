package com.roman.demo.webapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roman.demo.webapi.models.WebPushMessage;
import com.roman.demo.webapi.models.WebPushSubscription;
import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebService {


    @Autowired
    private ObjectMapper objectMapper;

    public static PushService pushService = new PushService();
    public static Map<String, WebPushSubscription> subscriptions = new ConcurrentHashMap<>();

    /**
     * create object notification which send to subscriber
     *
     * @param message
     */
    public void sendMessages(WebPushMessage message) {
        subscriptions.values()
                .forEach(subscription -> {
                            Notification notification;
                            try {
                                notification = new Notification(
                                        subscription.getNotificationEndPoint(),
                                        subscription.getPublicKey(),
                                        subscription.getAuth(),
                                        objectMapper.writeValueAsBytes(message));
                                pushService.send(notification);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                );
    }
}
