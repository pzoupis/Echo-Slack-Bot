package me.pzoupis.bot;

public class SlackEvent {
    private String token;
    private String challenge;
    private String type;

    public SlackEvent(String token, String challenge, String type) {
        this.token = token;
        this.challenge = challenge;
        this.type = type;
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
}