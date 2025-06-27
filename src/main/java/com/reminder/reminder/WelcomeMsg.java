package com.reminder.reminder;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMsg {
    public static String getMsg() {
        return "welcome to my web!";
    }
}
