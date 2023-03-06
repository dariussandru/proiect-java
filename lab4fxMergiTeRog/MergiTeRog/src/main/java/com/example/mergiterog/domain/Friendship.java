package com.example.mergiterog.domain;

import java.util.Date;

public class Friendship extends Entity{
    int idUser1;
    int idUser2;
    String status;
    String date;

    public Friendship(Integer id, int idUser1, int idUser2, String status, String  date) {
        super(id);
        this.idUser1 = idUser1;
        this.idUser2 = idUser2;
        this.status = status;
        this.date = date;
    }

    @Override
    public boolean equals(Object obj){return super.equals(obj);}

    public int getIdUser1() {return idUser1;}
    public void setIdUser1(int idUser1) {
        this.idUser1 = idUser1;
    }
    public int getIdUser2() {
        return idUser2;
    }
    public void setIdUser2(int idUser2) {this.idUser2 = idUser2;}
    public void setDate(String date) {this.date = date;}
    public String getDate() {return date;}
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Friendship{" +
                "idUser1=" + idUser1 +
                ", idUser2=" + idUser2 +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
