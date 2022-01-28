import logic.control.LoginControl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControlTest {

    @Test
    void searchUserTest() {
        LoginControl lg = new LoginControl();
        boolean ret = false;
        int conf = 1;

        if(lg.searchUserU("test",false)) {
            ret = lg.searchUser("test", "test", false);
        }


        if(ret)
            conf = 0;

        assertEquals(0,conf,0);
    }

    @Test
    void logOutTest(){
        LoginControl lg = new LoginControl();
        boolean ret = false;
        String user1 = null;
        int conf = 1;

        if(lg.searchUserU("test",false)) {
            ret = lg.searchUser("test", "test", false);
        }

        if(ret){
            LoginControl.logOut();
            user1 = lg.getUsername();
        }

        if(user1 != null)
            conf = 0;

        assertEquals(1,conf,0);
    }
}