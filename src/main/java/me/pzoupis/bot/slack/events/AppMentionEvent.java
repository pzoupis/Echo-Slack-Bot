package me.pzoupis.bot.slack.events;

import me.pzoupis.bot.StringHelper;

public class AppMentionEvent {
    private String type;
    private String user;
    private String text;
    private String ts;
    private String channel;
    private String event_ts;

    public AppMentionEvent(String type, String user, String text, String ts, String channel, String event_ts) {
        this.type = StringHelper.AddEmptyIfNull(type);
        this.user = StringHelper.AddEmptyIfNull(user);
        this.text = StringHelper.AddEmptyIfNull(text);
        this.ts = StringHelper.AddEmptyIfNull(ts);
        this.channel = StringHelper.AddEmptyIfNull(channel);
        this.event_ts = StringHelper.AddEmptyIfNull(event_ts);
    }

    public String getType() {
		return type;
	}

    public String getEvent_ts() {
		return event_ts;
	}

    public void setEvent_ts(String event_ts) {
		this.event_ts = event_ts;
	}

    public String getChannel() {
		return channel;
	}

    public void setChannel(String channel) {
		this.channel = channel;
	}

    public String getTs() {
		return ts;
	}

    public void setTs(String ts) {
		this.ts = ts;
	}

    public String getText() {
		return text;
	}

    public void setText(String text) {
		this.text = text;
	}

    public String getUser() {
		return user;
	}

    public void setUser(String user) {
		this.user = user;
	}

    public void setType(String type) {
		this.type = type;
    }
    
    @Override
    public String toString() {
        return "\ntype: " + type +
        "\nuser: " + user +
        "\ntext: " + text +
        "\nts: " + ts +
        "\nchannel: " + channel +
        "\nevent_ts: " + event_ts;
    }
}