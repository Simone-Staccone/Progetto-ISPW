package StatsLogic.Control;

import StatsLogic.Entity.Stats;

import java.io.IOException;

public class StatsController {

    public static Stats create(float points, float assists, float rebounds, float minutes){
        Stats s = new Stats(points, assists, rebounds, minutes);
        s.display();

        return s;
    }

    public static void write(float points, float assists, float rebounds, float minutes){
        Stats s = new Stats(points, assists, rebounds, minutes);
        FileManager fm = new FileManager("C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\points.txt");

        fm.writeAppend(Float.toString(points));

        fm.changePath("C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\assists.txt");

        fm.writeAppend(Float.toString(assists));

        fm.changePath("C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\rebounds.txt");

        fm.writeAppend(Float.toString(rebounds));

        fm.changePath("C:\\\\Users\\\\simon\\\\IdeaProjects\\\\ItalianBallerz\\\\src\\\\main\\\\java\\\\Data\\\\minutes.txt");

        fm.writeAppend(Float.toString(minutes));



    }

    public static Stats average() throws IOException {
        return StatsController.create(Stats.getAveregePoints(),Stats.getAveregeAssists(),Stats.getAveregeRebounds(),Stats.getAveregeMinutes());
    }
}
