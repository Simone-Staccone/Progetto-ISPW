package logic.bean;

import errorlogic.MyException;
import guicontroller.StatsInterfaceControl;
import logic.control.StatsController;
import logic.entity.Stat;

import java.io.IOException;
import java.util.List;

public class BeanStats {
    private BeanStats(){
    }


    public static void add(String points, String assists, String rebounds, String minutes) throws IOException {
        String res = BeanStats.control(points);
        String res2 = BeanStats.control(assists);
        String res3 = BeanStats.control(rebounds);
        String res4 = BeanStats.control(minutes);
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

    public static List<Stat> getStatsList() throws MyException
    {
        StatsController sc = new StatsController();
        return sc.getList();
    }

    public static void delete(int i) {
        StatsController st = new StatsController();
        st.delete(i);
    }

    public static Stat averege() throws MyException {
        StatsController st = new StatsController();
        Stat s;
        try {
            s = st.average();
        } catch (Exception e) {
            throw new MyException("Error message",e);
        }
        return s;
    }
}
