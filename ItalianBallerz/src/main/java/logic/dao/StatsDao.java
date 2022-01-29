package logic.dao;

import errorlogic.MyException;
import logic.control.FileManager;
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
}
