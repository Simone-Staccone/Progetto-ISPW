package logic.dao;

import errorlogic.MyException;
import logic.other.CourtConst;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe aggiunta per non ripetere le stesse righe di codice per ogni DAO, dato che la logica di scrittura e lettura su file
 * è sempre la stessa.
 * Inoltre aggiungendo questa classe si aumenta il disaccoppiamento tra DAO e file system, rendendo un eventuale passaggio
 * a DB più semplice.
 * Questa soluzione risente di una scarsa high coesion, dato che una sola classe comprende più operazioni, però aumenta
 * l'information hiding tra DAO e come sono scritti i file.
 */

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

    public boolean checkEnd() throws FileNotFoundException {
        boolean ret = false;

        FileManager.check(this.path);


        try (RandomAccessFile raf = new RandomAccessFile(this.path, "rw")){
            if(raf.length() == this.fp)
            {
                ret = true;
            }
        }
        catch(IOException e) {
            throw new FileNotFoundException();
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
            throw new FileNotFoundException();
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
            throw new FileNotFoundException();
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


            PrintWriter writer = new PrintWriter(this.path, StandardCharsets.UTF_8);
            for (String value : str) {
                writer.println(value);
            }
            writer.close();


        } catch (IOException ex) {
            throw new FileNotFoundException();
        }
    }

    public void writeAppend(String s,String what) throws MyException {
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
            throw new MyException("Problema di IO",e.getCause());
        }

        String res = s + "\n";


        try (RandomAccessFile raf = new RandomAccessFile(this.path + File.separator + what, "rw")){
            raf.seek(raf.length());
            raf.write(res.getBytes());
        }
        catch(IOException e) {
            throw new MyException("Problema di IO",e.getCause());
        }
    }

    public String search(String name, String symbol1, String symbol2) throws FileNotFoundException {
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
                    ret = FileManager.trySearch(name,symbol1,symbol2,s,str);
                    if(ret.compareTo("") != 0)
                        break;
                }
            }
            if(ret.compareTo("") != 0)
                break;
        }
        return ret;
    }

    private static String trySearch(String name, String symbol1, String symbol2, String s, String str) throws FileNotFoundException {
        String ret = "";
        FileManager fm2 = new FileManager(CourtConst.COURT + File.separator +  s + File.separator + str);
        String s2;
        while(!fm2.checkEnd()) {
            s2 = fm2.readLine();
            if (s2.compareTo("") != 0 && name.compareTo(s2.substring(0, s2.indexOf(CourtConst.FIRST_SYMBOL))) == 0) {
                if(symbol2 == null)
                {
                    ret = s2.substring(s2.indexOf(symbol1) + 1);
                }
                else
                {
                    ret = s2.substring(s2.indexOf(symbol1) + 1,s2.indexOf(symbol2));
                }
                break;
            }
        }

        return ret;
    }
}