package me.pzoupis.bot;

import me.pzoupis.bot.slack.events.AppMentionEvent;

public class StringHelper {
    public static String AddEmptyIfNull(String input) {
        if(input == null) {
            return "";
        } else {
            return input;
        }
    }

    public static String[] AddEmptyIfNull(String[] input) {
        if(input == null) {
            return new String[0];
        } else {
            return input;
        }
    }

    public static AppMentionEvent AddEmptyIfNull(AppMentionEvent input) {
        if(input == null) {
            return new AppMentionEvent("type", "user", "text", "ts", "channel", "event_ts");
        } else {
            return input;
        }
    }
}