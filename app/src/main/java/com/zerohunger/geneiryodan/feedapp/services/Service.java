package com.zerohunger.geneiryodan.feedapp.services;

import android.app.Activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.zerohunger.geneiryodan.feedapp.models.users.User;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.ERROR_OCCURRED;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.MESSAGE;

public class Service<T> {
    protected final String url = "http://192.168.213.2:8080/";
    protected Activity activity;
    protected HttpClient client;
    protected User user;

    public Service(Activity activity, User user) {
        this.activity = activity;
        this.user = user;
        client = new DefaultHttpClient();
    }

    protected Map<String,?> processRequest(T requestBody, String urn){
        try {
            HttpPost httpPost = new HttpPost(url + urn);
            Map<String, String> loginParams = ConfigurationService.getLoginParams(activity);
            StringEntity requestBodyEntity = new StringEntity(new Gson().toJson(requestBody));
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("Authorization", "Bearer " + loginParams.get("token"));
            httpPost.setEntity(requestBodyEntity);
            HttpResponse response = client.execute(httpPost);
            String json = EntityUtils.toString(response.getEntity());
            Map<String, ?> result = new ObjectMapper().readValue(json, HashMap.class);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> result = new HashMap<>();
            result.put(MESSAGE, ERROR_OCCURRED);
            return result;
        }
    }
}
