package logic.control;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        boolean ret = false;
        try {
            file = new File(this.path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(this.path, "rw");
            if(raf.length() == this.fp)
            {
                ret = true;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                Objects.requireNonNull(raf).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        RandomAccessFile raf = null;
        try {
            String res = text + "\n";
            raf = new RandomAccessFile(path, "rw");
            raf.seek(raf.length());
            raf.write(res.getBytes());
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                Objects.requireNonNull(raf).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        RandomAccessFile raf = null;
        try {
            StringBuilder buffer = new StringBuilder();
            raf = new RandomAccessFile(path, "rw");

            raf.seek(this.fp);

            buffer.append(raf.readLine());

            text = buffer.toString();
            this.fp = raf.getFilePointer();
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }finally{
            try {
                Objects.requireNonNull(raf).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
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
        }finally{
            try{
                Objects.requireNonNull(br).close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        RandomAccessFile raf  = null;
        try {
            String res = s + "\n";
            raf = new RandomAccessFile(this.path + "\\"+ what+ ".txt", "rw");
            raf.seek(raf.length());
            raf.write(res.getBytes());
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }finally{
            try {
                Objects.requireNonNull(raf).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}