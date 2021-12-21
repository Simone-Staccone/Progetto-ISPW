package Logic.Bean;

import Logic.Boundary.GUIView;
import Logic.Control.StatsController;

import java.io.IOException;

public class BeanStats {
    public static void add(String points, String assists, String rebounds, String minutes) throws IOException {
        String res = BeanStats.controlPoints(points);
        /* Integrare con soluzione try catch */
        if(res.compareTo("") == 0)
        {
            res = "Success";
            BeanStats.notify(res);
            StatsController.write(Float.parseFloat(points), Float.parseFloat(assists), Float.parseFloat(rebounds), Float.parseFloat(minutes));
        }
        else
        {
            BeanStats.notify(res);
        }
    }

    private static void notify(String res) {
        GUIView guistats = new GUIView();
        guistats.showM(res);
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
