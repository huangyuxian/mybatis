package edu.nf.ch09.entity;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private int uid;
    private String userName;
    //一对一关联身份证
    private IdCard card;
    //一对多关联联系电话
    private List<Tel> tels = new ArrayList<>();
    //多对多关联住址
    private List<Address> addresses = new ArrayList<>();

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public IdCard getCard() {
        return card;
    }

    public void setCard(IdCard card) {
        this.card = card;
    }

    public List<Tel> getTels() {
        return tels;
    }

    public void setTels(List<Tel> tels) {
        this.tels = tels;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
