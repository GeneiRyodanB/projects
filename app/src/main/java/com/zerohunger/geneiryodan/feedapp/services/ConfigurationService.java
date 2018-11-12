package com.zerohunger.geneiryodan.feedapp.services;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * Created by G521232 on 15/05/2018.
 */

public class ConfigurationService {



    public static void storeJWT(Activity activity, Map<String, String> data){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(activity.getApplicationContext().openFileOutput("config.txt", Context.MODE_PRIVATE));
            String dataJson = new Gson().toJson(data);
            outputStreamWriter.write(dataJson);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static Map<String, String> getLoginParams(Activity activity){
        String ret = "";
        Map<String, String> loginParams = null;
        try {
            InputStream inputStream = activity.getApplicationContext().openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                loginParams = new ObjectMapper().readValue(ret, Map.class);
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return loginParams;
    }

    public static void storeUserConfiguration(Activity activity, Map<String, Object> data){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(activity.getApplicationContext().openFileOutput("userConfig.txt", Context.MODE_PRIVATE));
            String dataJson = new Gson().toJson(data);
            outputStreamWriter.write(dataJson);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static Map<String, Object> getUserConfiguration(Activity activity){
        String ret = "";
        Map<String, Object> userConfig = null;
        try {
            InputStream inputStream = activity.getApplicationContext().openFileInput("userConfig.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                userConfig = new ObjectMapper().readValue(ret, Map.class);
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return userConfig;
    }

    public static void saveServerConfiguration(Activity activity, Map<String, String> configuration){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(activity.getApplicationContext().openFileOutput("serverConfig.txt", Context.MODE_PRIVATE));
            String dataJson = new Gson().toJson(configuration);
            outputStreamWriter.write(dataJson);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static Map<String, String> getServerConfiguration(Activity activity){
        String ret = "";
        Map<String, String> serverConfig = null;
        try {
            InputStream inputStream = activity.getApplicationContext().openFileInput("serverConfig.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                serverConfig = new ObjectMapper().readValue(ret, Map.class);
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return serverConfig;
    }

    public static void removeUserConfiguration(Activity activity){
        //File file = new File("userConfig.txt");
        activity.getApplicationContext().deleteFile("userConfig.txt");
        activity.getApplicationContext().deleteFile("config.txt");
    }
}
