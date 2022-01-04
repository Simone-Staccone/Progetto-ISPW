package guicontroller;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import logic.bean.BeanCourt;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.List;


public class PlaygroundShowInterfaceController extends GenericInterface{
    private boolean first = true;

    @FXML
    private TextField searchBar;
    @FXML
    private VBox courtList;

    @FXML
    public void search(){
        String s = searchBar.getText();
        List<HBox> bList = BeanCourt.search(s);
        if(courtList.getChildren().size() > 0)
            courtList.getChildren().remove(0);
        for(HBox b : bList)
        {
            courtList.getChildren().add(b);
        }
    }

    @FXML
    private void tryClear()
    {
        if(this.first)
        {
            searchBar.setText("");
            this.first = false;
        }
    }

    @FXML
    private void tryS(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            search();
    }
}
