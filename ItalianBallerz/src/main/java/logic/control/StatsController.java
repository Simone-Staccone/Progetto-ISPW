package logic.control;

import errorlogic.MyException;
import logic.entity.Stat;
import logic.entity.StatsList;
import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class StatsController {
    private String actualPath;

    public StatsController()
    {
        if(SingletonPlayer.getLoginInstance() != null)
            this.actualPath = CourtConst.USER_PACKAGE + File.separator + SingletonPlayer.getLoginInstance().getUsername() + File.separator;
    }
    public StatsController(String s)
    {
        this.actualPath = s;
    }

    public Stat create(float points, float assists, float rebounds, float minutes){
        return new Stat(points, assists, rebounds, minutes);
    }


    public void write(float points, float assists, float rebounds, float minutes){
        FileManager fm = new FileManager(this.actualPath);

        fm.writeAppend(Float.toString(points),CourtConst.POINTS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(assists),CourtConst.ASSISTS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(rebounds),CourtConst.REBOUNDS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(minutes),CourtConst.MINUTES + CourtConst.EXTENSION);
    }

    public Stat average() throws MyException {
        StatsController st = new StatsController(this.actualPath);
        return st.create(st.getAverege(CourtConst.POINTS),st.getAverege(CourtConst.ASSISTS),
                st.getAverege(CourtConst.REBOUNDS),st.getAverege(CourtConst.MINUTES));
    }

    public void delete(int i) {
        FileManager fm = new FileManager(this.actualPath + CourtConst.POINTS + CourtConst.EXTENSION);
        FileManager fm2 = new FileManager(this.actualPath + CourtConst.ASSISTS + CourtConst.EXTENSION);
        FileManager fm3 = new FileManager(this.actualPath + CourtConst.REBOUNDS + CourtConst.EXTENSION);
        FileManager fm4 = new FileManager(this.actualPath + CourtConst.MINUTES + CourtConst.EXTENSION);
        try{
            fm.deleteLine(i);
            fm2.deleteLine(i);
            fm3.deleteLine(i);
            fm4.deleteLine(i);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public float getAverege(String str) throws MyException
    {
        float x = 0;
        int count = 0;
        float avg = 0;
        StringBuilder buffer = new StringBuilder();
        String s;

        FileManager fm;
        try {
            fm = new FileManager(this.actualPath + str + CourtConst.EXTENSION);


            while(!fm.checkEnd()) {
                buffer.delete(0,buffer.length());
                buffer.append(fm.readLine());
                s = buffer.toString();
                count++;
                x+=Float.parseFloat(s);
            }
            if(count != 0)
                avg = x/count;
        }catch (FileNotFoundException e){
            throw new MyException("No file found",e);
        }
        return avg;
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
