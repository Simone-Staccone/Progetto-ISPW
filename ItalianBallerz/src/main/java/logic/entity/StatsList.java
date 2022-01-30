package logic.entity;

import logic.dao.StatListDao;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Model relativo alle liste di statistiche
 */
public class StatsList {
    private List<Stat> stlst;

    public StatsList() throws FileNotFoundException {
        StatListDao sld = new StatListDao();
        this.stlst = sld.setStatsList();
    }

    public List<Stat> getStlst() {
        return stlst;
    }
}
