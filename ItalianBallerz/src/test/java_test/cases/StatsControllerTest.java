package cases;

import logic.control.AveregeControl;
import logic.control.LoginControl;
import logic.entity.Stat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatsControllerTest {
    @Test
    void averege(){
        LoginControl lg = new LoginControl();
        AveregeControl ac = new AveregeControl();
        double points;
        double assists;
        double rebounds;
        double minutes;
        Stat st;

        try {
            if(lg.searchUserU("test",false)) {
                    lg.searchUser("test","test",false);
            }
            st = ac.average();
            points = st.getPoints();
            assists = st.getAssists();
            rebounds = st.getRebounds();
            minutes = st.getMinutes();
        } catch (Exception e) {
            points = 0.0;
            assists = 0.0;
            rebounds = 0.0;
            minutes = 0.0;
        }



        assertEquals(2.5, points, 0);
        assertEquals(2.5, assists, 0);
        assertEquals(4, rebounds, 0);
        assertEquals(5, minutes, 0);
    }
}