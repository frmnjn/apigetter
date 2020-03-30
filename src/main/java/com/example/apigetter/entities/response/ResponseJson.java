package com.example.apigetter.entities.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;

public class ResponseJson {
    boolean success;
    JSONArray data;

    public ResponseJson() {
    }

    public ResponseJson(boolean success, JSONArray data) {
        this.success = success;
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return getClass().getName() + "#" + success;
        }
    }
}