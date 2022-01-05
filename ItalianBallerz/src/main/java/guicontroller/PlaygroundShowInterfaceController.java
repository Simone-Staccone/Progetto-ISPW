package guicontroller;

import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.bean.BeanCourt;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.entity.Court;
import logic.entity.CourtCache;
import logic.other.Swap;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class PlaygroundShowInterfaceController extends GenericInterface implements Initializable {
    private boolean first = true;

    @FXML
    private TextField searchBar;
    @FXML
    private VBox courtList;
    @FXML
    private Button searchButton;

    @FXML
    public void search(){
        String s = searchBar.getText();
        List<HBox> bList = BeanCourt.search(s);

        courtList.getChildren().clear();
        if(bList.size() == 0)
            bList.add(new HBox(new Text("Nessun risultato per questa ricerca")));
        for(HBox b : bList)
        {
            b.setOnMouseClicked(MouseEvent -> {
                Text t = (Text)b.getChildren().get(0);
                CourtCache.setName(t.getText());
                Swap.goTo("Court.fxml", super.mainPane);
            });
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchButton.setOnMouseEntered(MouseEvent -> {
            searchButton.setBorder(new Border(new BorderStroke(Color.WHITE,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            searchButton.setCursor(Cursor.HAND);
        });

        searchButton.setOnMouseExited(MouseEvent -> {
            searchButton.setBorder(null);
            searchButton.setCursor(Cursor.DEFAULT);
        });

    }
}
