package logic.control;

import errorlogic.MyException;
import logic.entity.Stat;
import logic.entity.StatsList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Controller per gestire le istanze della classe Statm, derivata dallo use case per l'aggiunta di una nuova statistica
 */
public class StatsController {
    /**
     * Crea una nuova istanza di Stat
     * @param points punti
     * @param assists assist
     * @param rebounds rimbalzi
     * @param minutes minuti
     * @return
     */
    public Stat create(float points, float assists, float rebounds, float minutes){
        return new Stat(points, assists, rebounds, minutes);
    }


    /**
     * Salva una nuova istanza di Stat
     * @param points punti
     * @param assists assist
     * @param rebounds rimbalzi
     * @param minutes minuti
     * @return
     */
    public void write(float points, float assists, float rebounds, float minutes) throws MyException {
        Stat st = new Stat(points, assists, rebounds, minutes);
        st.write();
    }

    /**
     * Elimina una istanza di Stat salvata
     * @param i numero della statistica da cancellare in ordine di inserimmento
     * @return
     */
    public void delete(int i) throws IOException {
        Stat st = new Stat();
        st.delete(i);
    }

    /**
     * @return lista di statistiche dell'utente loggato
     * @throws MyException
     */
    public List<Stat> getList() throws MyException{
        List<Stat> stLst;
        boolean flag = true;
        try {
            StatsList st = new StatsList();
            stLst = st.getStlst();
            flag = false;
        } catch (Exception e) {
            throw new MyException("Errore nell'ottenere la lista di statistiche dell'utente",e.getCause());
        }finally {
            if(flag)
                stLst = new ArrayList<>();
        }
        return stLst;
    }
}
