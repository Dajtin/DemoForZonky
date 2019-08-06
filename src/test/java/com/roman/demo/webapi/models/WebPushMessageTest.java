package com.roman.demo.webapi.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebPushMessageTest {


    @Test
    public void webPushMessageObjectTest()   {
        WebPushMessage webPushMessage = new WebPushMessage("tittle", "address", "message");
        assertEquals("address", webPushMessage.getClickTarget());
        assertEquals("message", webPushMessage.getMessage());
        assertEquals("tittle", webPushMessage.getTitle());

    }
}
