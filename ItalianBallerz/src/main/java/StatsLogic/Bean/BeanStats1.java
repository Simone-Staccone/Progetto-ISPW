package StatsLogic.Bean;

import StatsLogic.Boundary.BoundaryAddstats;
import StatsLogic.Control.AddStatsController;
import StatsLogic.Entity.Stats;

import java.io.IOException;

public class BeanStats1 {
    public static void add(String points, String assists, String rebounds, String minutes) throws IOException {
        String res = BeanStats1.controlPoints(points);
        /* Integrare con soluzione try catch */
        if(res.compareTo("") == 0)
        {
            res = "Success";
            BeanStats1.notify(res);
            AddStatsController.create(Integer.parseInt(points), Integer.parseInt(assists), Integer.parseInt(rebounds), Integer.parseInt(minutes));
        }
        else
        {
            BeanStats1.notify(res);
        }
    }

    private static void notify(String res) {
        BoundaryAddstats.showM(res);
    }

    private static String controlPoints(String points)
    {
        String res = "";
        int conv = (int)Float.parseFloat(points);

        if(conv<0)
        {
            res = "Invalid number, points must be positive";
        }
        else if(Float.compare(conv,Float.parseFloat(points)) != 0)
        {
            res = "Invalid number, points must be integer";
        }
        return res;
    }

}
