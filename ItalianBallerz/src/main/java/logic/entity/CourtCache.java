package logic.entity;

public class CourtCache {
    private static String name;
    private static String location;
    private static String money;
    private static String phone;
    private static String owner;

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
}
