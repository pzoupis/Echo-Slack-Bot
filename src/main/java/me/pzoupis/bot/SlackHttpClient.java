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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SlackHttpClient {
    
    private final static Logger LOGGER = Logger.getLogger(SlackHttpClient.class.getName());

    @Value("${slack.post.url}")
    private String slackPostUrl;

    public void postText(String channel, String text) {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("text", text));
        params.add(new BasicNameValuePair("channel", channel));
        postMethod(params);
    }

    private void postMethod(List<NameValuePair> params) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(slackPostUrl);
            httpPost.addHeader("Authorization", "Bearer " + System.getenv("BOT_USER_OAUTH_ACCESS_TOKEN"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            CloseableHttpResponse response = client.execute(httpPost);
            LOGGER.info("Response from slack was: " + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}