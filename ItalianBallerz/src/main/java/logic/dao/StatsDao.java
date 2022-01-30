package logic.dao;

import errorlogic.MyException;
import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StatsDao {
    private static final String actualPath = CourtConst.USER_PACKAGE + File.separator + SingletonPlayer.getLoginInstance().getUsername() + File.separator;

    public List<Float> getAverege(String str) throws MyException {
        List<Float> list = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        String s;

        FileManager fm;
        try {
            fm = new FileManager(actualPath + str + CourtConst.EXTENSION);


            while(!fm.checkEnd()) {
                buffer.delete(0,buffer.length());
                buffer.append(fm.readLine());
                s = buffer.toString();
                list.add(Float.parseFloat(s));
            }
        }catch (FileNotFoundException e){
            throw new MyException("No file found",e);
        }
        return list;
    }

    public void write(float points, float assists, float rebounds, float minutes){
        FileManager fm = new FileManager(actualPath);

        fm.writeAppend(Float.toString(points),CourtConst.POINTS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(assists),CourtConst.ASSISTS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(rebounds),CourtConst.REBOUNDS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(minutes),CourtConst.MINUTES + CourtConst.EXTENSION);
    }

    public void delete(int number) {
        FileManager fm = new FileManager(actualPath + CourtConst.POINTS + CourtConst.EXTENSION);
        FileManager fm2 = new FileManager(actualPath + CourtConst.ASSISTS + CourtConst.EXTENSION);
        FileManager fm3 = new FileManager(actualPath + CourtConst.REBOUNDS + CourtConst.EXTENSION);
        FileManager fm4 = new FileManager(actualPath + CourtConst.MINUTES + CourtConst.EXTENSION);
        try{
            fm.deleteLine(number);
            fm2.deleteLine(number);
            fm3.deleteLine(number);
            fm4.deleteLine(number);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
