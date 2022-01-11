package logic.control;

import logic.other.SingletonPlayer;

import java.nio.file.Paths;


public class AddPlaygroundController {
    private final String path = Paths.get("").toAbsolutePath() + "\\src\\main\\java\\data\\court";


    public void addCourt(String name,String location, String phone, String money) {
        FileManager fm = new FileManager(path + "\\" + location);
        fm.writeAppend((name + "$" + phone + "%" + money + "@" + SingletonPlayer.getLoginInstance().getUsername()),location);
    }
}
