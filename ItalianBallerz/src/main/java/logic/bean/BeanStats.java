package logic.bean;

import errorlogic.MyException;
import logic.control.AveregeControl;
import logic.control.StatsController;
import logic.entity.Stat;

import java.io.IOException;
import java.util.List;

/**
 * Classe bean che fa comunicare i controller grafici con le classi control relative agli use cases riguardanti
 * la statistiche di un utente
 */
public class BeanStats {
    private BeanStats(){
    }


    public static void add(String points, String assists, String rebounds, String minutes) throws IOException {
        String res = BeanStats.control(points);
        String res2 = BeanStats.control(assists);
        String res3 = BeanStats.control(rebounds);
        String res4 = BeanStats.control(minutes);
        if(res.compareTo("") == 0 && res2.compareTo("") == 0 && res3.compareTo("") == 0 && res4.compareTo("") == 0)
        {
            StatsController st = new StatsController();
            try {
                st.write(Float.parseFloat(points), Float.parseFloat(assists), Float.parseFloat(rebounds), Float.parseFloat(minutes));
            } catch (MyException e) {
                throw new IOException();
            }
        }
    }


    /**
     * Classe di appoggio che ha la responsabilità di controllare che l'input sia corretto.
     * @param s stringa da controllare
     * @return
     */
    private static String control(String s)
    {
        String res = "";
        int conv = (int)Float.parseFloat(s);

        if(conv<0)
        {
            res = "Invalid number, must be positive";
        }
        else if(Float.compare(conv,Float.parseFloat(s)) != 0)
        {
            res = "Invalid number, must be integer";
        }
        return res;
    }

    public static List<Stat> getStatsList() throws MyException
    {
        StatsController sc = new StatsController();
        return sc.getList();
    }

    public static void delete(int i) throws IOException {
        StatsController st = new StatsController();
        st.delete(i);
    }

    /**
     * Classe che ha la responsabilità di recuperare le statistiche media dell'utente loggato.
     * Inoltre converte una eccezione generica dovuta dalla classe di control per trasformarla in un eccezione MyException
     * specifica del sistema.
     * @return
     * @throws MyException
     */
    public static Stat averege() throws MyException {
        AveregeControl ac = new AveregeControl();
        Stat s;
        s = ac.average();

        return s;
    }
}
