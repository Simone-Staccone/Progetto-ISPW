package logic.other;


import logic.entity.PlayerUser;

public class SingletonPlayer {
    private static SingletonPlayer instance = null;
    private static String username;
    private Boolean owner;


    protected SingletonPlayer(Boolean owner) {
        this.owner = owner;
    }

    public static synchronized  SingletonPlayer getLoginInstance() {
        if (SingletonPlayer.instance == null && PlayerUser.getUsernameP() != null){
            SingletonPlayer.instance = new SingletonPlayer(PlayerUser.getOwnerP());
            SingletonPlayer.username = PlayerUser.getUsernameP();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public static void deleteInstance(){
        if (SingletonPlayer.instance != null){
            SingletonPlayer.instance = null;
            SingletonPlayer.username = null;
            PlayerUser.setUsernameP(null);
        }
    }

    public Boolean getOwner() {
        return owner;
    }
}
