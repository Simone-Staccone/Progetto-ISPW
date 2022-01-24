package logic.control;

import logic.other.SingletonPlayer;

import java.io.File;
import java.nio.file.Paths;


public class AddPlaygroundController {
    private final String path = Paths.get("").toAbsolutePath() + File.separator + "src" + File.separator +
            "main" + File.separator + "java" + File.separator + "data" + File.separator + "court";


    public void addCourt(String name,String location, String phone, String money) {
        FileManager fm = new FileManager(path + File.separator + location);
        fm.writeAppend((name + "$" + phone + "%" + money + "@" + SingletonPlayer.getLoginInstance().getUsername()),location);
    }
}
