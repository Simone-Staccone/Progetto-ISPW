package logic.entity;


import errorlogic.MyException;
import logic.dao.StatsDao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Model relativo alle statistiche
 */
public class Stat {
    private float points;
    private float assists;
    private float rebounds;
    private float minutes;

    public Stat(float points, float assists, float rebounds, float minutes){
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.minutes = minutes;
    }

    public Stat() {
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


    public static List<Float> getAverege(String str) throws FileNotFoundException{
        StatsDao sd = new StatsDao();
        return sd.getAverege(str);
    }

    public void write() throws MyException {
        StatsDao sd = new StatsDao();
        sd.write(this.points, this.assists, this.rebounds, this.minutes);
    }

    public void delete(int number) throws IOException {
        StatsDao sd = new StatsDao();
        sd.delete(number);
    }
}
