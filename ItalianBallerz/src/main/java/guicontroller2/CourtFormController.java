package guicontroller2;

import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import logic.bean.BeanCourt2;
import logic.entity.Court;

import java.util.ArrayList;
import java.util.List;

public class CourtFormController extends GenericInterface {
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> listContainer;

    @FXML
    private void search(){
        String s = searchBar.getText();
        List<Court> crt = new ArrayList<>();
        listContainer.getItems().clear();

        crt = BeanCourt2.get(s);

        for(Court c : crt)
        {
            listContainer.getItems().addAll(c.getName());
        }
    }

    @FXML
    private void tryS(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            search();
    }
}
