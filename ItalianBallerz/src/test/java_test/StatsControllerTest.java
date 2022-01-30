import errorlogic.MyException;
import logic.control.AveregeControl;
import logic.control.LoginControl;
import logic.entity.Stat;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatsControllerTest {
    @Test
    void averege(){
        LoginControl lg = new LoginControl();

        if(lg.searchUserU("test",false)) {
            try {
                lg.searchUser("test","test",false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        AveregeControl ac = new AveregeControl();
        Stat st;
        try {
            st = ac.average();
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