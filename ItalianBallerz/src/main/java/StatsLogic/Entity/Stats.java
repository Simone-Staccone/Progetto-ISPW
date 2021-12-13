package StatsLogic.Entity;

import java.io.*;

public class Stats {
    private final int points;
    private final int assists;
    private final int rebounds;
    private final int minutes;

    public Stats(int points, int assists, int rebounds, int minutes){
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.minutes = minutes;
    }

    public void display() {
        System.out.println("Points: " + this.points + " Assists: " + this.assists + " Rebounds: " + this.rebounds + " Minutes: " + this.minutes);
    }

    public void writeOnFile(String s) throws IOException {
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\prova.txr";
        File file = null;
        try {
            file = new File(path);
            if (file.exists())
                System.out.println("Il file " + path + " esiste");
            else if (file.createNewFile())
                System.out.println("Il file " + path + " è stato crate");
            else
                System.out.println("Il file " + path + " non può essere crate");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String res = s + "\n";
            RandomAccessFile raf = new RandomAccessFile("src/main/java/Data/prova.txr", "rw");
            raf.seek(raf.length());
            raf.write(res.getBytes());
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


}
