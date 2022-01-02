package logic.control;

import logic.entity.Stat;
import logic.other.SingletonPlayer;

import java.nio.file.Paths;


public class StatsController {
    private String path = Paths.get("").toAbsolutePath() + "\\src\\main\\java\\data\\users\\";


    public Stat create(float points, float assists, float rebounds, float minutes){
        return new Stat(points, assists, rebounds, minutes);
    }

    public void write(float points, float assists, float rebounds, float minutes){
        FileManager fm = new FileManager(path + SingletonPlayer.getLoginInstance().getUsername());

        fm.writeAppend(Float.toString(points),"points");
        fm.writeAppend(Float.toString(assists),"assists");
        fm.writeAppend(Float.toString(rebounds),"rebounds");
        fm.writeAppend(Float.toString(minutes),"minutes");
    }

    public Stat average(){
        StatsController st = new StatsController();
        return st.create(st.getAverege("points"),st.getAverege("assists"),st.getAverege("rebounds"),st.getAverege("minutes"));
    }

    public Boolean delete(int i) {
        String path = this.path + SingletonPlayer.getLoginInstance().getUsername()+ "\\";
        FileManager fm = new FileManager(path + "points.txt");
        FileManager fm2 = new FileManager(path + "assists.txt");
        FileManager fm3 = new FileManager(path + "rebounds.txt");
        FileManager fm4 = new FileManager(path + "minutes.txt");
        Boolean b;
        try{
            fm.deleteLine(i);
            fm2.deleteLine(i);
            fm3.deleteLine(i);
            fm4.deleteLine(i);
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        }
        return b;
    }


    public float getAverege(String str)
    {
        String path = this.path + SingletonPlayer.getLoginInstance().getUsername() + "\\" +str + ".txt";
        float x = 0;
        int count = 0;
        float avg;
        StringBuilder buffer = new StringBuilder();
        String s;

        FileManager fm = new FileManager(path);

        while(!fm.checkEnd()) {
            buffer.delete(0,buffer.length());
            buffer.append(fm.readLine());
            s = buffer.toString();
            count++;
            x+=Float.parseFloat(s);
        }
        avg = x/count;
        return avg;
    }
}