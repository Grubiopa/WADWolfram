/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JuanAntonio
 */
@Entity
public class Movements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long projectId;
    double money;
    String userName;
    String projectTitle;
    Calendar fecha;

    public Movements(long id, long projectId, double money, String userName, Calendar fecha) {
        this.id = id;
        this.projectId = projectId;
        this.money = money;
        this.userName = userName;
        this.fecha = fecha;
    }

    public Movements(long id, long projectId, double money, Calendar fecha) {
        this.id = id;
        this.projectId = projectId;
        this.money = money;
        this.fecha = fecha;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

}
