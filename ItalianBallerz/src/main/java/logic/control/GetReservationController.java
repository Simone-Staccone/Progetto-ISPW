package logic.control;

import errorlogic.AlreadyReserved;
import errorlogic.NotLoggedException;
import logic.entity.Court;
import logic.entity.CourtCache;

import java.io.FileNotFoundException;

public class GetReservationController {

    public GetReservationController(int start) throws NotLoggedException, AlreadyReserved, FileNotFoundException {
        Court crt = new Court(CourtCache.getName());

        crt.search(start);
        crt.addReservation(start);
    }
}
