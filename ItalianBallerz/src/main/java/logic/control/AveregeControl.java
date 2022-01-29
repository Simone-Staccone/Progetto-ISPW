package logic.control;

import errorlogic.MyException;
import logic.entity.Stat;
import logic.other.CourtConst;

import java.util.List;

public class AveregeControl {
    public Stat average() throws MyException {
        StatsController st = new StatsController();
        List<Float> points;
        List<Float> assists;
        List<Float> rebounds;
        List<Float> minutes;
        float avgPoints = 0.0f;
        float avgAssists = 0.0f;
        float avgRebounds = 0.0f;
        float avgMinutes = 0.0f;

        try{
            points = Stat.getAverege(CourtConst.POINTS);
            assists = Stat.getAverege(CourtConst.ASSISTS);
            rebounds = Stat.getAverege(CourtConst.REBOUNDS);
            minutes = Stat.getAverege(CourtConst.MINUTES);

            avgPoints = AveregeControl.makeAvg(points);
            avgAssists = AveregeControl.makeAvg(assists);
            avgRebounds = AveregeControl.makeAvg(rebounds);
            avgMinutes = AveregeControl.makeAvg(minutes);
        } catch (Exception e) {
            e.printStackTrace();
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
        ret = ret/count;
        return ret;
    }
}
