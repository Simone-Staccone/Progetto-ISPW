package logic.control;

import errorlogic.MyException;
import logic.entity.Court;

/**
 * Controller che gestisce l'aggiunta di un nuovo campetto.
 * Ha la funzione di creator e ddi information expert per quanto riguarda la classe Court.
 */
public class AddPlaygroundController {

    public void addCourt(String name,String location, String phone, String money) throws MyException {
        Court crt = new Court(name,location,phone,money);
        crt.add();
    }
}
