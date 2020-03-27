package com.example.apigetter.entities.collected;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CollectedRdbms {
    int id;
    String data1;
    String data2;

    public CollectedRdbms(int id, String data1, String data2) {
        this.id = id;
        this.data1 = data1;
        this.data2 = data2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return getClass().getName() + "#" + id;
        }
    }

}
