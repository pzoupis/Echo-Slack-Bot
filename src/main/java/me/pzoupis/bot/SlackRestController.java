package me.pzoupis.bot;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack")
class SlackRestController {

    private SlackHttpClient slackHttpClient;
    private final static Logger LOGGER = Logger.getLogger(BotApplication.class.getName());

    public SlackRestController(SlackHttpClient slackHttpClient) {
        this.slackHttpClient = slackHttpClient;
    }
    
    @PostMapping
    String postRequest(@RequestBody SlackEvent input) {
        LOGGER.info(input.toString());

        if(input.getType().equalsIgnoreCase("url_verification")) {
            LOGGER.info("url_verification event");
            return input.getChallenge();
        } else if(input.getEvent().getType().equalsIgnoreCase("app_mention")) {
            LOGGER.info("app_mention event");
            String text = input.getEvent().getText();
            text = text.replace("<@UC24ATX5W>", "");
            slackHttpClient.postText(input.getEvent().getChannel(), text);
            return "";
        }
        return "";
    }
}