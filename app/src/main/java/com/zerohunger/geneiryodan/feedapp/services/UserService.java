package com.zerohunger.geneiryodan.feedapp.services;

import android.app.Activity;

import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.CONNECTED;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.ERROR_OCCURRED;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.MESSAGE;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.NEW_USER;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.TOKEN_GENERATED;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.zerohunger.geneiryodan.feedapp.models.users.User;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Activity activity;
    private final HttpClient client;
    private final String url = "http://192.168.213.2:8080/";
    private final String urnSignUp = "registration";
    private final String urnLogin = "login";
    private final String urnJWT = "token/generate-token";
    private User user;


    public UserService(User user, Activity activity){
        client = new DefaultHttpClient();
        this.user = user;
        this.activity = activity;
    }

    public Map<String, String> signUp() {
        try {
            Map<String, Object> usermap = mappingUser(user);
            HttpPost httpPost = new HttpPost(url + urnSignUp);
            StringEntity userJson = new StringEntity(new Gson().toJson(usermap));
            httpPost.setEntity(userJson);
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = client.execute(httpPost);
            String json = EntityUtils.toString(response.getEntity());
            Map<String, String> result = new ObjectMapper().readValue(json, HashMap.class);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> result = new HashMap<>();
            result.put(MESSAGE, ERROR_OCCURRED);
            return result;
        }
    }

    public Map<String, String> getJWT(){
        HttpResponse responseJWT;
        Map<String, String> resultToken;
        HttpPost httpPostJWT = new HttpPost(url + urnJWT);
        Map<String, String> loginParams = new HashMap<>();
        loginParams.put("tel", user.getTel());
        loginParams.put("password", user.getPassword());
        StringEntity loginJson = null;
        try {
            loginJson = new StringEntity(new Gson().toJson(loginParams));
            httpPostJWT.setEntity(loginJson);
            httpPostJWT.setHeader("Content-type", "application/json");
            responseJWT = client.execute(httpPostJWT);
            String jsonToken = EntityUtils.toString(responseJWT.getEntity());
            resultToken = new ObjectMapper().readValue(jsonToken, Map.class);
            resultToken.put(MESSAGE, TOKEN_GENERATED);
        } catch (Exception e) {
            e.printStackTrace();
            resultToken = new HashMap<>();
            resultToken.put(MESSAGE, ERROR_OCCURRED);
        }

        return resultToken;
    }

    public Map<String, Object> signInWithJWT(String tel){
        Map<String, Object> userInfo ;
        Map<String, String> loginParams = ConfigurationService.getLoginParams(activity);
        HttpPost httpPostLogin = new HttpPost(url + urnLogin);
        httpPostLogin.setHeader("Authorization", "Bearer " + loginParams.get("token"));
        try {
            StringEntity userTel = new StringEntity(tel);
            httpPostLogin.setEntity(userTel);
            HttpResponse response = client.execute(httpPostLogin);
            String json = EntityUtils.toString(response.getEntity());
            userInfo = new ObjectMapper().readValue(json, HashMap.class);
            if(userInfo.get(MESSAGE).equals(CONNECTED)) {
                ConfigurationService.storeUserConfiguration(activity, userInfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
            userInfo = new HashMap<>();
            userInfo.put(MESSAGE, ERROR_OCCURRED);
        }
        return userInfo;
    }

    private Map<String, Object> mappingUser(User user){
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("nom", user.getNom());
        userMap.put("prenom", user.getPrenom());
        userMap.put("email", user.getEmail());
        userMap.put("tel", user.getTel());
        userMap.put("ville", user.getVille());
        userMap.put("password", user.getPassword());
      //  userMap.put("role", user.getRole());
        return userMap;
    }
}
