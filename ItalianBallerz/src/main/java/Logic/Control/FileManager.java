package Logic.Control;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* Questa classe ha la responsabilità di comunicare con i file*/

public class FileManager {
    private long fp;
    private String path;

    public FileManager(String path)
    {
        this.path = path;
    }

    public void changePath(String path)
    {
        this.fp = 0;
        this.path = path;
    }

    public Boolean checkEnd()
    {
        File file;
        Boolean ret = false;
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


    public void writeAppend(String text)
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

    public String readAll(String path, String mode)
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


            RandomAccessFile raf = new RandomAccessFile(path, mode);

            while(raf.getFilePointer() < raf.length()) {
                buffer.append(raf.readLine());
            }
            text = buffer.toString();
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return text;
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
}