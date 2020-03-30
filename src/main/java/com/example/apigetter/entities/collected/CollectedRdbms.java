package com.example.apigetter.entities.collected;

import java.sql.Timestamp;

public class CollectedRdbms {

    private Long actor_id;
    private String first_name;
    private String last_name;
    private Timestamp last_update;

    public CollectedRdbms() {
    }

    public CollectedRdbms(Long actor_id, String first_name, String last_name, Timestamp last_update) {
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.last_update = last_update;
    }

    public Long getactor_id() {
        return actor_id;
    }

    public void setactor_id(Long actor_id) {
        this.actor_id = actor_id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }

    public Timestamp getlast_update() {
        return last_update;
    }

    public void setlast_update(Timestamp last_update) {
        this.last_update = last_update;
    }


}