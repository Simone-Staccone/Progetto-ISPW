package logic.dao;

import logic.other.CourtConst;

import java.io.FileNotFoundException;

public class PlayerDao {
    public boolean searchUserU(String user,boolean owner){
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
                name = name.substring(0, name.indexOf("$"));
                if (name.compareTo(user) == 0) {
                    b = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        fm.writeAppendE(name + "$" + password + "%" + email);
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
                psw = name.substring(name.indexOf("$") + 1, name.indexOf("%"));
                name = name.substring(0, name.indexOf("$"));

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
