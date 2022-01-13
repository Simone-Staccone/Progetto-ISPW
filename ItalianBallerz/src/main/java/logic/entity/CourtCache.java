package logic.entity;

import logic.control.FileManager;

import java.io.FileNotFoundException;

public class CourtCache {
    private static String name;
    private static String location;
    private static String money;
    private static String phone;
    private static String owner;

    private CourtCache(){
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CourtCache.name = name;
    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        CourtCache.location = location;
    }

    public static String getMoney() {
        return money;
    }

    public static void setMoney(String money) {
        CourtCache.money = money;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        CourtCache.phone = phone;
    }

    public static String getOwner() {
        return owner;
    }

    public static void setOwner(String owner) {
        CourtCache.owner = owner;
    }

    public static String findOwner(String name) throws FileNotFoundException {
        FileManager fm = new FileManager();
        return fm.searchOwner(name);
    }

    public static String findMoney(String name) throws FileNotFoundException {
        FileManager fm = new FileManager();
        return fm.searchMoney(name);
    }

    public static String findPhone(String name) throws FileNotFoundException {
        FileManager fm = new FileManager();
        return fm.searchPhone(name);
    }
}
