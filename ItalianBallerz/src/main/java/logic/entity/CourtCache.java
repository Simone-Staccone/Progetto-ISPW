package logic.entity;

public class CourtCache {
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CourtCache.name = name;
    }
}
