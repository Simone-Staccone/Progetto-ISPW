package logic.entity;

/**
 * Model relativo all'utente che per ultimo ha provato a fare login nel sistema
 */
public class PlayerCache {
    private static String username;
    private static boolean owner;

    private PlayerCache(){}

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        PlayerCache.username = username;
    }

    public static boolean isOwner() {
        return owner;
    }

    public static void setOwner(boolean owner) {
        PlayerCache.owner = owner;
    }
}
