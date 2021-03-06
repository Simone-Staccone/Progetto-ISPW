package cases;

import errorlogic.MyException;
import logic.control.GetPlaygroundListController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test per verificare il corretto funzionamento del set e del get dell'entitò CourtChache
 */
class GetPlaygroundListControllerTest {

    @Test
    void getCurrentName() {
        String s;
        GetPlaygroundListController gpc = new GetPlaygroundListController();
        gpc.setCacheName("test");

        s = gpc.getCurrentName();

        assertEquals(0,s.compareTo("test"),0);
    }

    @Test
    void getOwner() {
        String s = "";
        GetPlaygroundListController gpc = new GetPlaygroundListController();
        gpc.setCacheOwner("test");

        try {
            s = gpc.getOwner();
        } catch (MyException e) {
            e.printStackTrace();
        }

        assertEquals(0,s.compareTo("test"),0);
    }

    @Test
    void getLocation() {
        String s;
        GetPlaygroundListController gpc = new GetPlaygroundListController();
        gpc.setCacheLocation("test");

        s = gpc.getLocation();

        assertEquals(0,s.compareTo("test"),0);
    }

    @Test
    void getMoney() {
        String s;
        GetPlaygroundListController gpc = new GetPlaygroundListController();
        gpc.setCacheMoney("test");



        s = gpc.getMoney();


        assertEquals(0,s.compareTo("test"),0);
    }

    @Test
    void getPhone() {
        String s;
        GetPlaygroundListController gpc = new GetPlaygroundListController();
        gpc.setCachePhone("test");

        s = gpc.getPhone();

        assertEquals(0,s.compareTo("test"),0);
    }
}