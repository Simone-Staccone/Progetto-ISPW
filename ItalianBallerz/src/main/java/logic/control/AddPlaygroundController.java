package logic.control;

import java.nio.file.Paths;

;

public class AddPlaygroundController {
    private String path = Paths.get("").toAbsolutePath() + "\\src\\main\\java\\data\\court";


    public void addCourt(String name,String location) {
        FileManager fm = new FileManager(path);
        fm.writeAppend(location,name);
    }
}
