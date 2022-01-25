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

    public Stat create(float points, float assists, float rebounds, float minutes){
        return new Stat(points, assists, rebounds, minutes);
    }

    public void write(float points, float assists, float rebounds, float minutes){
        FileManager fm = new FileManager("users" + File.separator + SingletonPlayer.getLoginInstance().getUsername());

        fm.writeAppend(Float.toString(points),"points" + CourtConst.getExtension());
        fm.writeAppend(Float.toString(assists),"assists" + CourtConst.getExtension());
        fm.writeAppend(Float.toString(rebounds),"rebounds" + CourtConst.getExtension());
        fm.writeAppend(Float.toString(minutes),"minutes" + CourtConst.getExtension());
    }

    public Stat average() throws MyException {
        StatsController st = new StatsController();
        return st.create(st.getAverege("points"),st.getAverege("assists"),st.getAverege("rebounds"),st.getAverege("minutes"));
    }

    public void delete(int i) {
        String actualPath = "users" + File.separator + SingletonPlayer.getLoginInstance().getUsername()+ File.separator;
        FileManager fm = new FileManager(actualPath + "points" + CourtConst.getExtension());
        FileManager fm2 = new FileManager(actualPath + "assists" + CourtConst.getExtension());
        FileManager fm3 = new FileManager(actualPath + "rebounds" + CourtConst.getExtension());
        FileManager fm4 = new FileManager(actualPath + "minutes" + CourtConst.getExtension());
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
        String actualPath = "users" + File.separator + SingletonPlayer.getLoginInstance().getUsername() + File.separator +str + CourtConst.getExtension();
        float x = 0;
        int count = 0;
        float avg;
        StringBuilder buffer = new StringBuilder();
        String s;

        FileManager fm;
        try {
            fm = new FileManager(actualPath);

            while(!fm.checkEnd()) {
                buffer.delete(0,buffer.length());
                buffer.append(fm.readLine());
                s = buffer.toString();
                count++;
                x+=Float.parseFloat(s);
            }
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
