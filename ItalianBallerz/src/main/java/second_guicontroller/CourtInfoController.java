package second_guicontroller;

import errorlogic.AlreadyReserved;
import errorlogic.NotLoggedException;
import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.bean.BeanCourt;
import logic.other.Swap2;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourtInfoController extends GenericInterface implements Initializable {
    @FXML
    private Text owner;
    @FXML
    private Text name;
    @FXML
    private Text location;
    @FXML
    private Text money;
    @FXML
    private ListView<AnchorPane> listContainer;
    @FXML
    private Text errorText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        owner.setText(BeanCourt.getCurrentOwner());
        name.setText(BeanCourt.getCurrentName());
        location.setText(BeanCourt.getCurrentLocation());
        money.setText(BeanCourt.getCurrentMoney());

        for(int i = 0;i<24;i++){
            AnchorPane pane = new AnchorPane();
            int finalI = i;
            Text txt = new Text(i + ":00 - " + (i+1) + ":00");
            Button b = new Button("Prenota");

            txt.setLayoutX(5);
            txt.setLayoutY(15);

            b.setOnMouseEntered(event -> b.setCursor(Cursor.HAND));
            b.setOnMouseExited(event -> b.setCursor(Cursor.DEFAULT));
            b.setOnMouseClicked(event -> {
                errorText.setText("");
                try {
                    BeanCourt.addSchedule(finalI);
                    errorText.setText("Prenotazione finita correttamente");
                } catch (NotLoggedException e) {
                    errorText.setText("Devi aver effettuato il login per prenotare");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (AlreadyReserved e) {
                    errorText.setText("Hai già effettuato una prenotazione per questo orario");
                }
            });

            b.setLayoutX(3);
            b.setLayoutX(450);

            pane.getChildren().addAll(txt,b);
            listContainer.getItems().add(pane);
        }
    }

    @FXML
    private void swaptoSearch(){
        Swap2.goTo("CourtForm.fxml",mainPane);
    }
}
