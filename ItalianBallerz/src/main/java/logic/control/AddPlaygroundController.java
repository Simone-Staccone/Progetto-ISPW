package logic.control;

import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;


public class AddPlaygroundController {

    public void addCourt(String name,String location, String phone, String money) {
        FileManager fm = new FileManager(CourtConst.COURT + File.separator + location);
        fm.writeAppend((name + "$" + phone + "%" + money + "@" + SingletonPlayer.getLoginInstance().getUsername()),location + CourtConst.EXTENSION);
    }
}
