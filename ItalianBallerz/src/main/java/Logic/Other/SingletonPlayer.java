package Logic.Other;


import Logic.Entity.PlayerUser;

public class SingletonPlayer {
    private static SingletonPlayer instance = null;
    private  String username;


    protected SingletonPlayer(String init) {
        this.username = init;
        System.out.println("Ciao " + this.username);
    }

    public synchronized static SingletonPlayer getLoginInstance() {
        if (SingletonPlayer.instance == null && PlayerUser.getUsername() != null){
            SingletonPlayer.instance = new SingletonPlayer(PlayerUser.getUsername());
        }
        return instance;
    }



    public String getUsername() {
        return username;
    }

    public void deleteInstance(){
        if (SingletonPlayer.instance != null){
            SingletonPlayer.instance = null;
            this.username = null;
            PlayerUser.setUsername(null);
        }
    }
}
