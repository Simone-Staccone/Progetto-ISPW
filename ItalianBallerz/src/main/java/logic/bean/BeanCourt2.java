package logic.bean;

import errorlogic.MyException;
import second_guicontroller.HomeController;
import logic.control.AddPlaygroundController;
import logic.control.GetPlaygroundListController;
import logic.entity.Court;

import java.util.List;

public class BeanCourt2 {
    private BeanCourt2(){

    }

    public static List<Court> get(String s) {
        List<Court> crt;

        GetPlaygroundListController gpc = new GetPlaygroundListController();
        gpc.set(s);

        crt = gpc.getCourtList();

        return crt;
    }

    public static void addCourt(String name, String location, String phone, int money) throws MyException {
        if(name.compareTo("") == 0 || location.compareTo("") == 0 || phone.compareTo("") == 0)
            throw new MyException("Empty field",null);
        else {
            AddPlaygroundController apc = new AddPlaygroundController();
            apc.addCourt(name, location, phone, String.valueOf(money));
        }
    }

    public static void notifyOwner(String owner, String location, String name,String when) {
        HomeController hc = new HomeController();
        hc.notify(owner,location,name,when);
    }
}
