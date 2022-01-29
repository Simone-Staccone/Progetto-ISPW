package logic.entity;


import errorlogic.MyException;
import logic.dao.StatsDao;

import java.util.List;

public class Stat {
    private final float points;
    private final float assists;
    private final float rebounds;
    private final float minutes;

    public Stat(float points, float assists, float rebounds, float minutes){
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.minutes = minutes;
    }
    public float getPoints()
    {
        return this.points;
    }
    public float getAssists() {
        return this.assists;
    }
    public float getRebounds() {
        return this.rebounds;
    }
    public float getMinutes() {
        return this.minutes;
    }


    public static List<Float> getAverege(String str) throws MyException
    {
        StatsDao sd = new StatsDao();
        return sd.getAverege(str);
    }

}
