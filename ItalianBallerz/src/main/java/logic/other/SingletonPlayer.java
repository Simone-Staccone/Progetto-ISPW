package logic.other;


import logic.entity.PlayerUser;

public class SingletonPlayer {
    private static SingletonPlayer instance = null;
    private static String username;
    private Boolean owner;


    protected SingletonPlayer(String init, Boolean owner) {
        this.username = init;
        this.owner = owner;
    }

    public synchronized static SingletonPlayer getLoginInstance() {
        if (SingletonPlayer.instance == null && PlayerUser.getUsernameP() != null){
            SingletonPlayer.instance = new SingletonPlayer(PlayerUser.getUsernameP(),PlayerUser.getOwnerP());
        }
        return instance;
    }

    public String getUsername() {
        return this.username;
    }

    public void deleteInstance(){
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
