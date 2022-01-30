package logic.entity;

import errorlogic.AlreadyReserved;
import errorlogic.NotLoggedException;
import logic.dao.CourtDao;

import java.io.FileNotFoundException;

public class Court {
    private String name;
    private String location;
    private String owner;
    private String phone;
    private String money;

    public Court(String name){
        this.name = name;
    }

    public Court(String name, String location, String phone, String money) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void addReservation(int start) throws NotLoggedException {
        CourtDao cd = new CourtDao();
        cd.addReservation(start,this.name);
    }

    public void search(int start) throws FileNotFoundException, AlreadyReserved {
        CourtDao cd = new CourtDao();
        cd.search(start,this.name);
    }

    public void add(){
        CourtDao cd = new CourtDao();
        cd.add(this.name,this.location,this.phone,this.money);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
