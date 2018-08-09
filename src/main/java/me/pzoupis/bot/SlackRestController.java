package me.pzoupis.bot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
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

        if(!input.getChallenge().isEmpty()) {
            LOGGER.info("Challenge");
            return input.getChallenge();
        } else {
            LOGGER.info("Event");
            try {
                CloseableHttpClient client = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost("https://slack.com/api/chat.postMessage");
                httpPost.addHeader("Authorization", "Bearer xoxb-355280296021-410146949200-MCo6HtFAxuHJ6HIVOVfVWJgp");
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("text", input.getEvent().getText()));
                params.add(new BasicNameValuePair("channel", input.getEvent().getChannel()));
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                CloseableHttpResponse response = client.execute(httpPost);
                LOGGER.info(response.getStatusLine().getReasonPhrase());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}