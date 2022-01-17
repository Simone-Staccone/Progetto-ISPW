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

    public FileManager(String path)
    {
        this.path = path;
    }
    public FileManager()
    {

        this.path = Paths.get("").toAbsolutePath() + "\\src\\main\\java\\data\\";
    }

    private static void check(String path) throws FileNotFoundException{
        try {
            File file = new File(path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    public Boolean checkEnd() throws FileNotFoundException {
        boolean ret = false;
        FileManager.check(this.path);

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


    public void writeAppendE(String text) throws FileNotFoundException
    {
        FileManager.check(this.path);


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

    public void exist() throws FileNotFoundException{
        File file;
        file = new File(this.path);
        if (!file.exists())
            throw new FileNotFoundException();
    }

    public String readLine() throws FileNotFoundException {
        String text = "";
        FileManager.check(this.path);

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

    public void deleteLine(int i) throws FileNotFoundException {
        FileManager.check(this.path);

        File file = new File(path);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
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
        File file = null;
        folder = new File(this.path);
        if (!folder.exists())
            folder.mkdir();
        try {
            file = new File(this.path + File.separator + what + ".txt");
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file.getAbsolutePath());

        try {
            String res = s + "\n";
            RandomAccessFile raf = new RandomAccessFile(this.path + "\\"+ what + ".txt", "rw");
            raf.seek(raf.length());
            raf.write(res.getBytes());
            raf.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String searchOwner(String name) throws FileNotFoundException {
        String actualPath = this.path + CourtConst.getCourt() + File.separator;
        File file = new File(actualPath);
        String[] names = file.list();
        String ret = "";


        for(String s : Objects.requireNonNull(names))
        {
            File file2 = new File(actualPath + s);
            if (file2.isDirectory()) {
                String[] subNames = file2.list();
                for (String str : Objects.requireNonNull(subNames)) {
                    FileManager fm2 = new FileManager(actualPath + s + "\\"+ str);
                    ret = FileManager.tryFind(fm2,name);
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
        String actualPath = this.path + "court\\";
        File file = new File(actualPath);
        String[] names = file.list();
        String ret = "";


        for(String s : Objects.requireNonNull(names))
        {
            File file2 = new File(actualPath + s);
            if (file2.isDirectory()) {
                String[] subNames = file2.list();
                for (String str : Objects.requireNonNull(subNames)) {
                    FileManager fm2 = new FileManager(actualPath + s + "\\"+ str);
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
        String actualPath = this.path + "court\\";
        File file = new File(actualPath);
        String[] names = file.list();
        String ret = "";


        for(String s : Objects.requireNonNull(names))
        {
            File file2 = new File(actualPath + s);
            if (file2.isDirectory()) {
                String[] subNames = file2.list();
                for (String str : Objects.requireNonNull(subNames)) {
                    FileManager fm2 = new FileManager(actualPath + s + "\\"+ str);
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