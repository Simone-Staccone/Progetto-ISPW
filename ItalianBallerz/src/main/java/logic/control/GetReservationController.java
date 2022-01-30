package logic.control;

import errorlogic.AlreadyReserved;
import errorlogic.NotLoggedException;
import logic.bean.BeanCourt;
import logic.bean.BeanCourt2;
import logic.entity.Court;
import logic.entity.CourtCache;

import java.io.FileNotFoundException;

public class GetReservationController {
    public void tryAdd(int start) throws FileNotFoundException, AlreadyReserved, NotLoggedException {
        Court crt = new Court(CourtCache.getName());
        crt.search(start);
        crt.addReservation(start);
        BeanCourt.notifyOwner(CourtCache.getOwner(),CourtCache.getLocation(),CourtCache.getName());
        BeanCourt2.notifyOwner(CourtCache.getOwner(),CourtCache.getLocation(),CourtCache.getName(),String.valueOf(start));
    }
}
