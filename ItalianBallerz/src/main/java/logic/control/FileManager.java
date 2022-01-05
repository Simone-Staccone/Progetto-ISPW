package logic.control;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Questa classe ha la responsabilità di comunicare con i file*/

public class FileManager {
    private long fp;
    private final String path;

    public FileManager(String path)
    {
        this.path = path;
    }

    public Boolean checkEnd()
    {
        File file;
        boolean ret = false;
        try {
            file = new File(this.path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(this.path, "rw");
            if(raf.length() == this.fp)
            {
                ret = true;
            }
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return ret;
    }


    public void writeAppendE(String text)
    {
        File file;
        try {
            file = new File(this.path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String res = text + "\n";
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.seek(raf.length());
            raf.write(res.getBytes());
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine()
    {
        File file;
        String text = "";
        try {
            file = new File(this.path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            StringBuilder buffer = new StringBuilder();


            RandomAccessFile raf = new RandomAccessFile(path, "rw");

            raf.seek(this.fp);

            buffer.append(raf.readLine());

            text = buffer.toString();
            this.fp = raf.getFilePointer();
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public void deleteLine(int i){
        File file = null;
        try {
            file = new File(this.path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<String> str = new ArrayList<>();
            String s = "";
            int count = 0;
            do{
                s = br.readLine();
                if(count != i)
                {
                    if(s!=null && s.compareTo("") != 0)
                        str.add(s);
                }
                count++;
            }while(s != null);
            br.close();

            PrintWriter writer = new PrintWriter(this.path, "UTF-8");
            for(int j = 0;j<str.size();j++){
                writer.println(str.get(j));
            }
            writer.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeAppend(String s,String what) {
        File folder;
        File file = null;
        folder = new File(this.path);
        if (!folder.exists())
            folder.mkdir();
        try {
            file = new File(this.path + "\\"+ what+ ".txt");
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file.getAbsolutePath());

        try {
            String res = s + "\n";
            RandomAccessFile raf = new RandomAccessFile(this.path + "\\"+ what+ ".txt", "rw");
            raf.seek(raf.length());
            raf.write(res.getBytes());
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}