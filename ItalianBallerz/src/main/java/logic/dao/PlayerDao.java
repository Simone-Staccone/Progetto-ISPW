package logic.dao;

import logic.other.CourtConst;

import java.io.FileNotFoundException;

/**
 * Dao per la comunicazione con il file system
 */
public class PlayerDao {
    public boolean searchUserU(String user,boolean owner) throws FileNotFoundException {
        String path;
        String name;
        boolean b = false;

        if(owner)
            path = CourtConst.OWNER;
        else
            path = CourtConst.LOG;



        FileManager fm = new FileManager(path + CourtConst.EXTENSION);

        try {
            while (!fm.checkEnd()) {
                name = fm.readLine();
                name = name.substring(0, name.indexOf(CourtConst.FIRST_SYMBOL));
                if (name.compareTo(user) == 0) {
                    b = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        return b;
    }


    public void writePlayerUser(String name, String password,String email,boolean owner) throws FileNotFoundException {
        String path;
        if(owner)
            path = CourtConst.OWNER;
        else
            path = CourtConst.LOG;


        FileManager fm = new FileManager(path + CourtConst.EXTENSION);
        fm.writeAppendE(name + CourtConst.FIRST_SYMBOL + password + CourtConst.SECOND_SYMBOL + email);
    }


    public boolean searchUser(String user,String password,boolean owner) throws FileNotFoundException {
        String path;

        if(owner)
            path = CourtConst.OWNER;
        else
            path = CourtConst.LOG;


        String name;
        String psw;
        boolean b = false;

        FileManager fm = new FileManager(path + CourtConst.EXTENSION);

        while (!fm.checkEnd()) {
            name = fm.readLine();

            try {
                psw = name.substring(name.indexOf(CourtConst.FIRST_SYMBOL) + 1, name.indexOf(CourtConst.SECOND_SYMBOL));
                name = name.substring(0, name.indexOf(CourtConst.FIRST_SYMBOL));

                if (name.compareTo(user) == 0 && psw.compareTo(password) == 0) {
                    b = true;
                    break;
                }
            } catch (Exception e) {
                throw new FileNotFoundException();
            }
        }

        return b;
    }
}
