package StatsLogic.Control;

import StatsLogic.Entity.Stats;
import eu.hansolo.tilesfx.icons.Flag;

import java.io.IOException;

public class StatsController {

    public static Stats create(float points, float assists, float rebounds, float minutes) throws IOException {
        Stats s = new Stats(points, assists, rebounds, minutes);
        s.display();

        return s;
    }

    public static void write(float points, float assists, float rebounds, float minutes) throws IOException {
        Stats s = new Stats(points, assists, rebounds, minutes);


        s.writeOnFile(Float.toString(points),"C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\points.txt");
        s.writeOnFile(Float.toString(assists),"C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\assists.txt");
        s.writeOnFile(Float.toString(rebounds),"C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\rebounds.txt");
        s.writeOnFile(Float.toString(minutes),"C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\minutes.txt");

    }

    public static Stats average() throws IOException {
        return StatsController.create(Stats.getAveregePoints(),Stats.getAveregeAssists(),Stats.getAveregeRebounds(),Stats.getAveregeMinutes());
    }
}
