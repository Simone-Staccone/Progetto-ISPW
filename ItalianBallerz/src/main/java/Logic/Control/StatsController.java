package Logic.Control;

import Logic.Entity.Stat;

import java.io.IOException;

public class StatsController {
    public Stat create(float points, float assists, float rebounds, float minutes){
        return new Stat(points, assists, rebounds, minutes);
    }

    public void write(float points, float assists, float rebounds, float minutes){
        new Stat(points, assists, rebounds, minutes);
        FileManager fm = new FileManager("C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\points.txt");

        fm.writeAppend(Float.toString(points));

        fm.changePath("C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\assists.txt");

        fm.writeAppend(Float.toString(assists));

        fm.changePath("C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\rebounds.txt");

        fm.writeAppend(Float.toString(rebounds));

        fm.changePath("C:\\\\Users\\\\simon\\\\IdeaProjects\\\\ItalianBallerz\\\\src\\\\main\\\\java\\\\Data\\\\minutes.txt");

        fm.writeAppend(Float.toString(minutes));



    }

    public Stat average() throws IOException {
        StatsController st = new StatsController();
        return st.create(st.getAverege("points"),st.getAverege("assists"),st.getAverege("rebounds"),st.getAverege("minutes"));
    }


    public float getAverege(String str)
    {
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\" + str + ".txt";
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
