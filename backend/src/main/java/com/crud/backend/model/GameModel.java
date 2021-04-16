package com.crud.backend.model;

import java.text.SimpleDateFormat;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class GameModel {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="sport")
    private String sport;
    @Column(name="admin")
    private String admin;
    @Column(name="place")
    private String place;
    @Column(name="date")
    private SimpleDateFormat date;

    
    // constructor
    public GameModel(int id, String sport, String admin, String place, SimpleDateFormat date) {
        this.id = id;
        this.sport = sport;
        this.admin = admin;
        this.place = place;
        this.date = date;
    }

    // getters && setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSport() {
        return this.sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getAdmin() {
        return this.admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public SimpleDateFormat getDate() {
        return this.date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GameModel)) {
            return false;
        }
        GameModel game = (GameModel) o;
        return id == game.id && Objects.equals(sport, game.sport) && Objects.equals(admin, game.admin) && Objects.equals(date, game.date);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", sport='" + getSport() + "'" +
            ", admin='" + getAdmin() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }


     


}
