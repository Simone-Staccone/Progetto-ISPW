import errorlogic.MyException;
import logic.control.StatsController;
import logic.entity.Stat;
import logic.other.CourtConst;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatsControllerTest {
    @Test
    public void write(){
    }

    @Test
    public void averege(){
        StatsController sc = new StatsController(CourtConst.USER_PACKAGE + File.separator +
                "test" + File.separator);
        Stat st;
        try {
            st = sc.average();
            double points = st.getPoints();
            double assists = st.getAssists();
            double rebounds = st.getRebounds();
            double minutes = st.getMinutes();

            assertEquals(2.5, points, 0);
            assertEquals(2.5, assists, 0);
            assertEquals(4, rebounds, 0);
            assertEquals(5, minutes, 0);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}