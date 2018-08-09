package me.pzoupis.bot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack")
class SlackRestController {
    @PostMapping
    String postRequest(@RequestBody SlackEvent input) {
        if(input.getChallenge() != null) {
            return input.getChallenge();
        } else {
            return "";
        }
    }
}