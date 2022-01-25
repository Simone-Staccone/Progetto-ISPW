package logic.control;

import logic.other.SingletonPlayer;

import java.io.File;


public class AddPlaygroundController {
    private final String path = "court";


    public void addCourt(String name,String location, String phone, String money) {
        FileManager fm = new FileManager(path + File.separator + location);
        fm.writeAppend((name + "$" + phone + "%" + money + "@" + SingletonPlayer.getLoginInstance().getUsername()),location);
    }
}
