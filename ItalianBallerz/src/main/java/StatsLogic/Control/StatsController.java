package StatsLogic.Control;

import StatsLogic.Entity.Stats;

import java.io.IOException;

public class StatsController {

    public static Stats create(int points, int assists, int rebounds, int minutes) throws IOException {
        Stats s = new Stats(points, assists, rebounds, minutes);
        s.display();

        String res;

        res = "Points:" + points + " Assists: " + assists + " Rebounds: " + rebounds + " Minutes: "+ minutes;

        s.writeOnFile(res);
        return s;
    }
}
