package me.pzoupis.bot;

import me.pzoupis.bot.slack.events.AppMentionEvent;

public class SlackEvent {
    private String token;
    private String challenge;
    private String type;
    private AppMentionEvent event;
    private String team_id;
    private String api_app_id;
    private String[] authed_users;
    private String event_id;
    private String event_time;

    public SlackEvent(String token,
            String challenge, 
            String type,
            AppMentionEvent event,
            String team_id,
            String api_app_id,
            String[] authed_users,
            String event_id,
            String event_time) {
        this.token = StringHelper.AddEmptyIfNull(token);
        this.challenge = StringHelper.AddEmptyIfNull(challenge);
        this.type = StringHelper.AddEmptyIfNull(type);
        this.event = StringHelper.AddEmptyIfNull(event);
        this.team_id = StringHelper.AddEmptyIfNull(team_id);
        this.api_app_id = StringHelper.AddEmptyIfNull(api_app_id);
        this.authed_users = StringHelper.AddEmptyIfNull(authed_users);
        this.event_id = StringHelper.AddEmptyIfNull(event_id);
        this.event_time = StringHelper.AddEmptyIfNull(event_time);
    }

    public String getEvent_time() {
		return event_time;
	}

    public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}

    public String getEvent_id() {
		return event_id;
	}

    public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

    public String[] getAuthed_users() {
		return authed_users;
	}

    public void setAuthed_users(String[] authed_users) {
		this.authed_users = authed_users;
	}

    public String getApi_app_id() {
		return api_app_id;
	}

    public void setApi_app_id(String api_app_id) {
		this.api_app_id = api_app_id;
	}

    public String getTeam_id() {
		return team_id;
	}

    public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

    public AppMentionEvent getEvent() {
		return event;
	}

    public void setEvent(AppMentionEvent event) {
		this.event = event;
    }
    
	public String getToken() {
		return token;
	}

    public String getType() {
		return type;
	}

    public void setType(String type) {
		this.type = type;
	}

    public String getChallenge() {
		return challenge;
	}

    public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

    public void setToken(String token) {
		this.token = token;
    }
    
    @Override
    public String toString() {
        return "\nToken: " + token +
        "\nChallenge: " + challenge +
        "\nType: " + type +
        "\nEvent: " + event.toString() +
        "\nteam_id: " + team_id +
        "\napi_app_id: " + api_app_id +
        "\nauthed_users: " + printAuthedUsers() +
        "\nevent_id: " + event_id +
        "\nevent_time: " + event_time;
    }

    private String printAuthedUsers() {
        String authedUsers = "";
        for (String authed_user : authed_users) {
            authedUsers = authedUsers + ", " + authed_user;
        }
        return authedUsers;
    }
}