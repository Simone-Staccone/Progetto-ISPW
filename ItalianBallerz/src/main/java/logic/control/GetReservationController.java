package logic.control;

import errorlogic.AlreadyReserved;
import errorlogic.NotLoggedException;
import logic.bean.BeanCourt;
import logic.bean.BeanCourt2;
import logic.entity.Court;
import logic.entity.CourtCache;

import java.io.FileNotFoundException;

public class GetReservationController {
    private final Court crt;

    public GetReservationController(){
        this.crt = new Court(CourtCache.getName());
    }

    public void tryAdd(int start) throws FileNotFoundException, AlreadyReserved, NotLoggedException {
        this.crt.search(start);
        this.crt.addReservation(start);
        BeanCourt.notifyOwner(CourtCache.getOwner(),CourtCache.getLocation(),CourtCache.getName());
        BeanCourt2.notifyOwner(CourtCache.getOwner(),CourtCache.getLocation(),CourtCache.getName(),String.valueOf(start));
    }
}
