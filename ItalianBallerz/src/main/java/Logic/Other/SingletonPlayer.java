package Logic.Other;


import Logic.Entity.PlayerUser;

public class SingletonPlayer {

    private static SingletonPlayer instance = null;
    private  String username = null;


    protected SingletonPlayer(String init) {
        this.username = init;
    }

    public SingletonPlayer() {
    }

    public synchronized static SingletonPlayer getLoginInstance() {
        if (SingletonPlayer.instance == null){
            SingletonPlayer.instance = new SingletonPlayer(PlayerUser.getUsername());
        }
        return instance;
    }

    public String getUsername() {
        return this.username;
    }

}
