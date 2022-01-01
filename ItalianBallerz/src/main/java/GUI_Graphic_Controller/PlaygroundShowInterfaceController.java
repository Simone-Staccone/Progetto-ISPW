package gui_Graphic_Controller;

import Logic.Bean.BeanCourt;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.List;


public class PlaygroundShowInterfaceController extends GenericInterface{
    private boolean first = true;

    @FXML
    private TextField searchBar;

    @FXML
    public void search(){
        String s = searchBar.getText();
        List<HBox> bList = BeanCourt.search(s);
    }

    @FXML
    private void tryClear()
    {
        if(first)
        {
            searchBar.setText("");
            first = false;
        }
    }



}
