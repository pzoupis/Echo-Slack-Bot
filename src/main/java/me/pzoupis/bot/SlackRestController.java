package me.pzoupis.bot;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack")
class SlackRestController {

    private final static Logger LOGGER = Logger.getLogger(BotApplication.class.getName());

    @PostMapping
    String postRequest(@RequestBody SlackEvent input) {
        LOGGER.info(input.toString());
        if(input.getChallenge() != null) {
            return input.getChallenge();
        } else {
            return "";
        }
    }
}