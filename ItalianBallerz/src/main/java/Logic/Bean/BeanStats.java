package logic.bean;

import guicontroller.StatsInterfaceControl;
import logic.control.StatsController;
import logic.entity.Stat;
import logic.entity.StatsList;

import java.io.IOException;
import java.util.List;

public class BeanStats {
    public static void add(String points, String assists, String rebounds, String minutes) throws IOException {
        String res = BeanStats.control(points);
        String res2 = BeanStats.control(assists);
        String res3 = BeanStats.control(rebounds);
        String res4 = BeanStats.control(minutes);
        /* Integrare con soluzione try catch */
        if(res.compareTo("") == 0 && res2.compareTo("") == 0 && res3.compareTo("") == 0 && res4.compareTo("") == 0)
        {
            res = "Success";
            BeanStats.notify(res);
            StatsController st = new StatsController();
            st.write(Float.parseFloat(points), Float.parseFloat(assists), Float.parseFloat(rebounds), Float.parseFloat(minutes));
        }
        else
        {
            BeanStats.notify(res);
        }
    }

    private static void notify(String res) {
        StatsInterfaceControl guistats = new StatsInterfaceControl();
        guistats.showM(res);
    }

    private static String control(String s)
    {
        String res = "";
        int conv = (int)Float.parseFloat(s);

        if(conv<0)
        {
            res = "Invalid number, must be positive";
        }
        else if(Float.compare(conv,Float.parseFloat(s)) != 0)
        {
            res = "Invalid number, must be integer";
        }
        return res;
    }

    public static List<Stat> getStatsList()
    {
        StatsList st = new StatsList();
        return st.getStlst();
    }

    public static void delete(int i) {
        StatsController st = new StatsController();
        st.delete(i);
    }

    public static Stat averege() throws IOException {
        StatsController st = new StatsController();
        Stat s = null;
        try {
            s = st.average();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
