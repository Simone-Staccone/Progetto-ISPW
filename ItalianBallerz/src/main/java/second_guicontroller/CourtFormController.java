package second_guicontroller;

import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import logic.bean.BeanCourt;
import logic.bean.BeanCourt2;
import logic.entity.Court;
import logic.other.Swap2;

import java.util.List;

/**
 * Controller grafico che si occupa della gestione della form relativa alla ricerca di nuovi campetti
 */
public class CourtFormController extends GenericInterface {
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> listContainer;

    @FXML
    private void search(){
        String s = searchBar.getText();
        List<Court> crt;
        listContainer.getItems().clear();

        crt = BeanCourt2.get(s);

        int i = 0;

        for(Court c : crt)
        {
            listContainer.getItems().add(i + " . " + c.getName());
            listContainer.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2){
                    String s1 = event.getTarget().toString();
                    BeanCourt.setCacheName(s1.substring(s1.indexOf(".") + 2,s1.length()-1));
                    BeanCourt.setCacheLocation(s);
                    Swap2.goTo("CourtInfo.fxml",mainPane);
                }
            });
            i++;
        }
        if(listContainer.getItems().size() == 0)
            listContainer.getItems().add("Nessun risultato trovato in questa città");
    }

    @FXML
    private void tryS(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            search();
    }
}
