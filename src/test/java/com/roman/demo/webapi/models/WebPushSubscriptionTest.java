package com.roman.demo.webapi.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebPushSubscriptionTest {

    @Test
    public void webPushSubscriptionObjectTest()   {
        WebPushSubscription webPushSubscription = new WebPushSubscription();
        webPushSubscription.setAuth("authorization");
        webPushSubscription.setNotificationEndPoint("endPoint");
        webPushSubscription.setPublicKey("publicKez");
        
        assertEquals("endPoint", webPushSubscription.getNotificationEndPoint());
        assertEquals("authorization", webPushSubscription.getAuth());
        assertEquals("publicKez", webPushSubscription.getPublicKey());

    }
}
