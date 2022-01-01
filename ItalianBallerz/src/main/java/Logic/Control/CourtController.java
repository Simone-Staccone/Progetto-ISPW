package logic.control;;

public class CourtController {
    private String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\Court";

    public CourtController(){
    }

    public void addCourt(String name,String location) {
        FileManager fm = new FileManager(path);
        fm.writeAppend(name,location);
    }
}
