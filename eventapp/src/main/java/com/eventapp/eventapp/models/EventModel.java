package com.eventapp.eventapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvent;
    private String eventName;
    private String eventDate;
    private String eventLocal;


    public String getEventLocal() {
        return eventLocal;
    }

    public void setEventLocal(String eventLocal) {
        this.eventLocal = eventLocal;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

}
