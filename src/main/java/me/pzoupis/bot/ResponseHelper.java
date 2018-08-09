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

public class ResponseHelper {
    
    private final static Logger LOGGER = Logger.getLogger(ResponseHelper.class.getName());

    public static void postText(String channel, String text) {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("text", text));
        params.add(new BasicNameValuePair("channel", channel));
        postMethod(params);
    }

    private static void postMethod(List<NameValuePair> params) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("https://slack.com/api/chat.postMessage");
            httpPost.addHeader("Authorization", "Bearer xoxb-355280296021-410146949200-MCo6HtFAxuHJ6HIVOVfVWJgp");
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