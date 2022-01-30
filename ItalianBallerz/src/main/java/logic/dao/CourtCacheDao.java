package logic.dao;

import logic.other.CourtConst;

import java.io.FileNotFoundException;

/**
 * Dao per la comunicazione con il file system
 */
public class CourtCacheDao {
    public String findOwner(String name) throws FileNotFoundException {
        FileManager fm = new FileManager();
        return fm.search(name, CourtConst.THIRD_SYMBOL,null);
    }

    public static String findMoney(String name) throws FileNotFoundException {
        FileManager fm = new FileManager();
        return fm.search(name,CourtConst.SECOND_SYMBOL ,CourtConst.THIRD_SYMBOL);
    }

    public static String findPhone(String name) throws FileNotFoundException {
        FileManager fm = new FileManager();
        return fm.search(name,CourtConst.FIRST_SYMBOL,CourtConst.SECOND_SYMBOL);
    }
}
