package logic.other;

import logic.entity.PlayerCache;
import logic.entity.PlayerUser;

/**
 * Classe singleton che ha la responsabilit√† di mantenre un unica istanza relativa all'utente loggato
 */
public class SingletonPlayer {
    private static SingletonPlayer instance = null;
    private PlayerUser playerUser;


    private SingletonPlayer(String init, Boolean owner) {
        this.playerUser = new PlayerUser(init,owner);
    }

    public static synchronized  SingletonPlayer getLoginInstance() {
        if (SingletonPlayer.instance == null && PlayerCache.getUsername() != null){
            SingletonPlayer.instance = new SingletonPlayer(PlayerCache.getUsername(),PlayerCache.isOwner());
        }
        return instance;
    }

    public String getUsername() {
        return playerUser.getUsername();
    }

    public static void deleteInstance(){
        if (SingletonPlayer.instance != null){
            PlayerCache.setUsername(null);
            SingletonPlayer.instance.playerUser.setUsername(null);
            SingletonPlayer.instance.playerUser = null;
            SingletonPlayer.instance = null;
        }
    }

    public Boolean getOwner() {
        return playerUser.getOwner();
    }
}
