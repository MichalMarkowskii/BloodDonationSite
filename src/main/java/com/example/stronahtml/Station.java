package com.example.stronahtml;

import java.util.List;

/**
 * Klasa Station reprezentuje pojedynczą stację i przechowuje informacje
 * o danych stacji a także listę zawierającą statusy poszczególnych grup krwi.
 */

public class Station {
    private int id;
    private String rckik;
    private String adress;
    private String city;
    private int phone;
    private String url;
    private List<String> statuses;

    public Station() {
    }

    public Station(int id, String rckik, String adress, String city, int phone, String url, List<String> statuses) {
        this.id = id;
        this.rckik = rckik;
        this.adress = adress;
        this.city = city;
        this.phone = phone;
        this.url = url;
        this.statuses = statuses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRckik() {
        return rckik;
    }

    public void setRckik(String rckik) {
        this.rckik = rckik;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<String> statuses) {
        this.statuses = statuses;
    }
}