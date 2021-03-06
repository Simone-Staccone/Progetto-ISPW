package logic.bean;

import errorlogic.AlreadyReserved;
import errorlogic.MyException;
import errorlogic.NotLoggedException;
import guicontroller.LoggedInterfaceController;
import logic.control.AddPlaygroundController;
import logic.control.GetPlaygroundListController;
import logic.control.GetReservationController;
import logic.entity.Court;
import logic.entity.CourtList;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Classe bean che fa comunicare i controller grafici con le classi control relative agli use cases dei campetti
 */
public class BeanCourt {
    private BeanCourt(){
    }

    public static void set(String name) {
        GetPlaygroundListController gpl = new GetPlaygroundListController();
        gpl.set(name);
    }

    /**
     * La classe ha la responsabilit√† di propagare la richiesta di aggiungere un nuovo campetto dopo un controllo
     * dei parametri da aggiungere.
     * @param name name del campetto
     * @param location luogo dove si trova
     * @param phone numero di telefono
     * @param money costo
     * @throws MyException
     */
    public static void addCourt(String name, String location, String phone, String money) throws MyException{
        if(name.compareTo("") == 0 || location.compareTo("") == 0 || phone.compareTo("") == 0 || money.compareTo("") == 0) {
            throw new MyException("Empty field",null);
        }
        else {
            AddPlaygroundController cc = new AddPlaygroundController();
            cc.addCourt(name, location, phone, money);
        }
    }

    public static String getCurrentName() {
        GetPlaygroundListController gp = new GetPlaygroundListController();
        return gp.getCurrentName();
    }

    public static void setCacheName(String name){
        GetPlaygroundListController gp = new GetPlaygroundListController();
        gp.setCacheName(name);
        gp.setCacheMoney(name);
        gp.setCachePhone(name);
        try {
            gp.setCacheOwner(name);
        } catch (Exception e) {
            gp.setCacheOwner("Non trovato!");
        }
    }

    public static void setCacheLocation(String name){
        GetPlaygroundListController gp = new GetPlaygroundListController();
        gp.setCacheLocation(name);
    }

    public static String getCurrentOwner() {
        GetPlaygroundListController gp = new GetPlaygroundListController();
        String s;
        try {
            s = gp.getOwner();
        } catch (Exception e) {
            s = "Non trovato";
        }
        return s;
    }

    public static String getCurrentLocation() {
        GetPlaygroundListController gr = new GetPlaygroundListController();
        return gr.getLocation();
    }

    public static String getCurrentMoney() {
        GetPlaygroundListController gr = new GetPlaygroundListController();
        return gr.getMoney();
    }

    public static String getCurrentPhone() {
        GetPlaygroundListController gr = new GetPlaygroundListController();
        return gr.getPhone();
    }

    public static void addSchedule(int start) throws NotLoggedException, FileNotFoundException, AlreadyReserved {
        GetReservationController gr = new GetReservationController();
        gr.tryAdd(start);
    }

    public static void notifyOwner(String owner, String location, String name) {
        LoggedInterfaceController lg = new LoggedInterfaceController();
        lg.notify(owner,location,name);
    }

    public static List<Court> get() {
        return CourtList.getCourts();
    }
}
