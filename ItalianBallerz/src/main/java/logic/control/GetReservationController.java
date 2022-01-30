package logic.control;

import errorlogic.AlreadyReserved;
import errorlogic.NotLoggedException;
import logic.bean.BeanCourt;
import logic.bean.BeanCourt2;
import logic.entity.Court;
import logic.entity.CourtCache;

import java.io.FileNotFoundException;

/**
 * Controller applicativo che ha la responsabilità di gestire le prenotazioni di un campetto.
 * In particolare la classe propaga 3 eccezioni di cui AlreadyReserved e NotLoggedException sono tipiche del sistema.
 */
public class GetReservationController {
    public void tryAdd(int start) throws FileNotFoundException, AlreadyReserved, NotLoggedException {
        Court crt = new Court(CourtCache.getName());
        crt.search(start);
        crt.addReservation(start);
        GetReservationController.notify(CourtCache.getOwner(),CourtCache.getLocation(),CourtCache.getName(),start);
    }

    /**
     * Il metodo notifica le Bean e quindi i controller grafici che mostrano una nuova prenotazione al proprietario.
     * @param owner proprietario del campetto
     * @param location luogo dove si trova
     * @param name nome del campetto
     * @param start orario
     */
    private static void notify(String owner, String location, String name, int start)
    {
        BeanCourt.notifyOwner(owner, location, name);
        BeanCourt2.notifyOwner(owner, location, name, String.valueOf(start));
    }
}
