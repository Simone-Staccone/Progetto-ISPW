package StatsLogic.Entity;

import java.io.*;

public class Stats {
    private final float points;
    private final float assists;
    private final float rebounds;
    private final float minutes;

    public Stats(float points, float assists, float rebounds, float minutes){
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
        return this.assists;
    }
    public float getMinutes() {
        return this.assists;
    }

    public void display() {
        System.out.println("Points: " + this.points + " Assists: " + this.assists + " Rebounds: " + this.rebounds + " Minutes: " + this.minutes);
    }

    public void writeOnFile(String s, String path)  {
        File file;
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
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.seek(raf.length());
            raf.write(res.getBytes());
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static float getAveregePoints()
    {
        float x = 0;
        int count = 0;
        float avg = 0;


        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\points.txt";
        File file;
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
            StringBuilder buffer = new StringBuilder();
            String s;


            RandomAccessFile raf = new RandomAccessFile("src/main/java/Data/points.txt", "rw");

            while(raf.getFilePointer() < raf.length()) {
                buffer.delete(0,buffer.length());
                buffer.append(raf.readLine());
                s = buffer.toString();
                count++;
                x+=Float.parseFloat(s);
                System.out.println(s);
            }
            avg = x/count;
            System.out.println("La media è:"+avg);
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return avg;
    }


    public static float getAveregeAssists()
    {
        float x = 0;
        int count = 0;
        float avg = 0;


        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\assists.txt";
        File file;
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
            StringBuilder buffer = new StringBuilder();
            String s;


            RandomAccessFile raf = new RandomAccessFile("src/main/java/Data/assists.txt", "rw");

            while(raf.getFilePointer() < raf.length()) {
                buffer.delete(0,buffer.length());
                buffer.append(raf.readLine());
                s = buffer.toString();
                count++;
                x+=Float.parseFloat(s);
                System.out.println(s);

            }
            avg = x/count;
            System.out.println("La media è:"+avg);
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return avg;
    }




    public static float getAveregeRebounds()
    {
        float x = 0;
        int count = 0;
        float avg = 0;


        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\rebounds.txt";
        File file;
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
            StringBuilder buffer = new StringBuilder();
            String s;


            RandomAccessFile raf = new RandomAccessFile("src/main/java/Data/rebounds.txt", "rw");

            while(raf.getFilePointer() < raf.length()) {
                buffer.delete(0,buffer.length());
                buffer.append(raf.readLine());
                s = buffer.toString();
                count++;
                x+=Float.parseFloat(s);
                System.out.println(s);

            }
            avg = x/count;
            System.out.println("La media è:"+avg);
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return avg;
    }

    public static float getAveregeMinutes()
    {
        float x = 0;
        int count = 0;
        float avg = 0;


        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\minutes.txt";
        File file;
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
            StringBuilder buffer = new StringBuilder();
            String s;


            RandomAccessFile raf = new RandomAccessFile("src/main/java/Data/minutes.txt", "rw");

            while(raf.getFilePointer() < raf.length()) {
                buffer.delete(0,buffer.length());
                buffer.append(raf.readLine());
                s = buffer.toString();
                count++;
                x+=Float.parseFloat(s);
                System.out.println(s);

            }
            avg = x/count;
            System.out.println("La media è:"+avg);
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return avg;
    }


}
