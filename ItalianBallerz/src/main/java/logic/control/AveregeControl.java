package logic.control;

import errorlogic.MyException;
import logic.entity.Stat;
import logic.other.CourtConst;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Controller che gestisce la restituzione della media delle statistiche dell'utente loggato.
 * Converte le eccezioni generiche in MyException, tipica del sistema.
 *
 */
public class AveregeControl {
    public Stat average() throws MyException {
        StatsController st = new StatsController();
        List<Float> points;
        List<Float> assists;
        List<Float> rebounds;
        List<Float> minutes;
        float avgPoints;
        float avgAssists;
        float avgRebounds;
        float avgMinutes;

        try{
            points = Stat.getAverege(CourtConst.POINTS);
            assists = Stat.getAverege(CourtConst.ASSISTS);
            rebounds = Stat.getAverege(CourtConst.REBOUNDS);
            minutes = Stat.getAverege(CourtConst.MINUTES);

            avgPoints = AveregeControl.makeAvg(points);
            avgAssists = AveregeControl.makeAvg(assists);
            avgRebounds = AveregeControl.makeAvg(rebounds);
            avgMinutes = AveregeControl.makeAvg(minutes);
        } catch (FileNotFoundException f) {
            throw new MyException(f.getCause());
        }

        return st.create(avgPoints,avgAssists,avgRebounds,avgMinutes);
    }

    public static float makeAvg(List<Float> lst){
        int count = 0;
        float ret = 0.0f;

        for(float num : lst){
            ret+=num;
            count++;
        }
        if(count != 0)
            ret = ret/count;
        return ret;
    }
}
