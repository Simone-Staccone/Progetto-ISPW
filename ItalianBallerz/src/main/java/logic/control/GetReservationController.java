package logic.control;

import errorlogic.NotLoggedException;
import logic.entity.Court;
import logic.entity.CourtCache;

public class GetReservationController {

    public GetReservationController(int start) throws NotLoggedException {
        Court crt = new Court(CourtCache.getName());
        crt.addReservation(start);
    }
}
