package com.roman.demo.webapi.models;

public class WebPushMessage {
    public WebPushMessage(String title, String clickTarget, String message) {
        this.title = title;
        this.clickTarget = clickTarget;
        this.message = message;
    }

    private String title;
    private String clickTarget;
    private String message;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClickTarget() {
        return clickTarget;
    }

    public void setClickTarget(String clickTarget) {
        this.clickTarget = clickTarget;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
