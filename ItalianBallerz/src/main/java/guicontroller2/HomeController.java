package guicontroller2;

import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import logic.other.Swap2;

public class HomeController extends GenericInterface {

    @FXML
    private void swaptoStatForm(){
        Swap2.goTo("StatsForm.fxml",mainPane);
    }
}
