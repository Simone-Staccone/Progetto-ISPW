package StatsLogic.Boundary;


import StatsLogic.Bean.BeanStats1;

import java.io.IOException;


public class BoundaryAddstats {
    public static void addStats(String points, String assists, String rebounds, String minutes) throws IOException {
        BeanStats1.add(points,assists,rebounds,minutes);
    }

    public void getStats()
    {

    }

    public static void showM(String s){
        System.out.println("Interaction returned: " + s);
    }
}
