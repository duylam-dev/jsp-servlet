package com.javaweb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;
    public HttpUtil(String value){
        this.value = value;
    }
    //convert string json to object T
    public <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    //convert json to string json
    public static HttpUtil of(BufferedReader reader){
        StringBuilder sb = new StringBuilder();
        String line;
            try {
               while((line = reader.readLine()) != null){
                   sb.append(line);
               }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return new HttpUtil(sb.toString());
    }
}
