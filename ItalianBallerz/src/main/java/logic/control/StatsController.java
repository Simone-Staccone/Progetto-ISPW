package logic.control;

import errorlogic.MyException;
import logic.entity.Stat;
import logic.entity.StatsList;

import java.util.ArrayList;
import java.util.List;


public class StatsController {
    public Stat create(float points, float assists, float rebounds, float minutes){
        return new Stat(points, assists, rebounds, minutes);
    }


    public void write(float points, float assists, float rebounds, float minutes){
        Stat st = new Stat(points, assists, rebounds, minutes);
        st.write();
    }

    public void delete(int i) {
        Stat st = new Stat();
        st.delete(i);
    }

    public List<Stat> getList() throws MyException{
        List<Stat> stLst = null;
        boolean flag = true;
        try {
            StatsList st = new StatsList();
            stLst = st.getStlst();
            flag = false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(flag)
                stLst = new ArrayList<>();
        }
        return stLst;
    }
}
