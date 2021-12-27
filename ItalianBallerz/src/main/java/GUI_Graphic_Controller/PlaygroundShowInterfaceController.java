package GUI_Graphic_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public class PlaygroundShowInterfaceController extends GenericInterface{
    @FXML
    private TextField searchList;

    private boolean first = true;

    @FXML
    private void tryClear()
    {
        if(first)
        {
            searchList.setText("");
            first = false;
        }
    }



}
