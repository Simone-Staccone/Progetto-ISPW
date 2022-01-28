package logic.control;

import logic.other.CourtConst;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* Questa classe ha la responsabilità di comunicare con i file*/

public class FileManager {
    private long fp;
    private final String path;
    private final String constPath = Paths.get("").toAbsolutePath() + File.separator + "src" +
            File.separator + "main" + File.separator + "java" + File.separator + "data" + File.separator;

    public FileManager(String path)
    {
        this.path = constPath + path;
    }
    public FileManager()
    {
        this.path = constPath;
    }

    private static void check(String path) throws FileNotFoundException{
        try {
            File file = new File(path);
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                if(!newFile)
                    throw new IOException();
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    public Boolean checkEnd() throws FileNotFoundException {
        boolean ret = false;



        FileManager.check(this.path);


        try (RandomAccessFile raf = new RandomAccessFile(this.path, "rw")){
            if(raf.length() == this.fp)
            {
                ret = true;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return ret;
    }


    public void writeAppendE(String text) throws FileNotFoundException
    {
        FileManager.check(this.path);

        String res = text + "\n";

        try (RandomAccessFile raf = new RandomAccessFile(this.path, "rw")){
            raf.seek(raf.length());
            raf.write(res.getBytes());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    public String readLine() throws FileNotFoundException {
        String text = "";

        FileManager.check(this.path);
        StringBuilder buffer = new StringBuilder();



        try (RandomAccessFile raf = new RandomAccessFile(this.path, "rw")){
            raf.seek(this.fp);

            buffer.append(raf.readLine());

            text = buffer.toString();
            this.fp = raf.getFilePointer();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public void deleteLine(int i) throws FileNotFoundException {
        FileManager.check(this.path);

        File file = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            List<String> str = new ArrayList<>();
            String s;
            int count = 0;
            do{
                s = br.readLine();
                if(count != i && s!=null && s.compareTo("") != 0)
                {
                        str.add(s);
                }
                count++;
            }while(s != null);
            br.close();

            PrintWriter writer = new PrintWriter(this.path, StandardCharsets.UTF_8);
            for (String value : str) {
                writer.println(value);
            }
            writer.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeAppend(String s,String what) {
        File folder;
        File file;
        folder = new File(this.path);

        try {
            if (!folder.exists()) {
                final boolean mkdir = folder.mkdir();
                if(!mkdir)
                    throw new IOException();
            }

            file = new File(this.path + File.separator + what);
            if (!file.exists()) {
                final boolean newFile = file.createNewFile();
                if(!newFile)
                    throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String res = s + "\n";


        try (RandomAccessFile raf = new RandomAccessFile(this.path + File.separator + what, "rw")){
            raf.seek(raf.length());
            raf.write(res.getBytes());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String searchOwner(String name) throws FileNotFoundException {
        String actualPath = this.path + CourtConst.COURT + File.separator;
        File file = new File(actualPath);
        String[] names = file.list();
        String ret = "";


        for(String s : Objects.requireNonNull(names))
        {
            File file2 = new File(actualPath + s);
            if (file2.isDirectory()) {
                String[] subNames = file2.list();
                for (String str : Objects.requireNonNull(subNames)) {
                    FileManager fm2 = new FileManager("court" + File.separator +  s + File.separator + str);
                    String s2;
                    while(!fm2.checkEnd()) {
                        s2 = fm2.readLine();
                        if (s2.compareTo("") != 0 && name.compareTo(s2.substring(0, s2.indexOf("$"))) == 0) {
                            ret = s2.substring(s2.indexOf("@") + 1);
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    private static String tryFind(FileManager fm2, String name) throws FileNotFoundException {
        String s2 = "";
        while(!fm2.checkEnd()) {
            s2 = fm2.readLine();
            if (s2.compareTo("") != 0 && name.compareTo(s2.substring(0, s2.indexOf("$"))) == 0) {
                s2 = s2.substring(s2.indexOf("@") + 1);
                break;
            }
        }
        return s2;
    }

    public String searchMoney(String name) throws FileNotFoundException {
        String actualPath = this.path + "court" + File.separator;
        File file = new File(actualPath);
        String[] names = file.list();
        String ret = "";


        for(String s : Objects.requireNonNull(names))
        {
            File file2 = new File( actualPath + s);
            if (file2.isDirectory()) {
                String[] subNames = file2.list();
                for (String str : Objects.requireNonNull(subNames)) {
                    FileManager fm2 = new FileManager( "court" + File.separator +  s + File.separator + str);
                    String s2;
                    while(!fm2.checkEnd()) {
                        s2 = fm2.readLine();
                        if (s2.compareTo("") != 0 && name.compareTo(s2.substring(0, s2.indexOf("$"))) == 0) {
                            ret = s2.substring(s2.indexOf("%")+1,s2.indexOf("@"));
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    public String searchPhone(String name) throws FileNotFoundException {
        String actualPath = this.path + "court" + File.separator;
        File file = new File(actualPath);
        String[] names = file.list();
        String ret = "";


        for(String s : Objects.requireNonNull(names))
        {
            File file2 = new File(actualPath + s);
            if (file2.isDirectory()) {
                String[] subNames = file2.list();
                for (String str : Objects.requireNonNull(subNames)) {
                    FileManager fm2 = new FileManager("court" + File.separator +  s + File.separator + str);
                    String s2;
                    while(!fm2.checkEnd()) {
                        s2 = fm2.readLine();
                        if (s2.compareTo("") != 0 && name.compareTo(s2.substring(0, s2.indexOf("$"))) == 0) {
                            ret = s2.substring(s2.indexOf("$")+1,s2.indexOf("%"));
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }


}