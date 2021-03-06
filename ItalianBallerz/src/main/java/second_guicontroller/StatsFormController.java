package second_guicontroller;

import errorlogic.MyException;
import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.bean.BeanStats;
import logic.entity.Stat;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller grafico che gestisce la form che mostra le statistiche dell'utente e genera la media di esse, permettendone anche
 * l'aggiunta di nuove.
 */
public class StatsFormController extends GenericInterface implements Initializable {
    @FXML
    private SplitMenuButton points;
    @FXML
    private SplitMenuButton assists;
    @FXML
    private SplitMenuButton rebounds;
    @FXML
    private SplitMenuButton minutes;
    @FXML
    private Text returnText;
    @FXML
    private ListView<String> listContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Stat> statList;
        try {
            int i = 0;
            statList = BeanStats.getStatsList();
            for(Stat s : statList){
                listContainer.getItems().add(i + ".Points: " + Math.round(s.getPoints()) +
                        " Assists: " + Math.round(s.getAssists())  +
                        " Rebounds: " + Math.round(s.getRebounds())  +
                        " Minutes: " + Math.round(s.getMinutes()) );
                i++;
            }
            if(statList.size() == 0){
                listContainer.getItems().add("Nessuna statistica trovata");
            }
        } catch (MyException e) {
            listContainer.getItems().add("Non ci sono statistiche per questo utente");
        }

        listContainer.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Text t;
                Stage stage = new Stage();
                try {
                    t = (Text)event.getTarget();
                    StatsFormController sfc = new StatsFormController();
                    sfc.deleteWindow(Integer.parseInt(t.getText().substring(0,1)));
                } catch (Exception e) {
                    returnText.setText("Errore");
                }finally{
                    stage.close();
                }


            }
        });


        for(int i = 0;i<=100;i++) {
            String s = String.valueOf(i);
            MenuItem menu1 = new MenuItem(s);
            MenuItem menu2 = new MenuItem(s);
            MenuItem menu3 = new MenuItem(s);
            MenuItem menu4 = new MenuItem(s);

            int finalI = i;
            menu1.setOnAction(event -> points.setText(String.valueOf(finalI)));


            menu2.setOnAction(event -> assists.setText(String.valueOf(finalI)));

            menu3.setOnAction(event -> rebounds.setText(String.valueOf(finalI)));

            menu4.setOnAction(event -> minutes.setText(String.valueOf(finalI)));


            points.getItems().add(menu1);
            assists.getItems().add(menu2);
            rebounds.getItems().add(menu3);
            minutes.getItems().add(menu4);
        }
    }

    private void deleteWindow(int i) {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane,300,100);

        Button button = new Button("Cancella");

        pane.getChildren().add(button);

        button.setLayoutX(120);
        button.setLayoutY(35);

        button.setOnMouseClicked(event -> {
            try {
                BeanStats.delete(i);
            } catch (IOException e) {
                returnText.setText("Cancellazione non riuscita");
            }
            stage.close();
        });
        button.setOnMouseEntered(event -> button.setCursor(Cursor.HAND));
        button.setOnMouseExited(event -> button.setCursor(Cursor.DEFAULT));

        stage.setTitle("Delete");
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    private void getAverege(){
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Media");
        Pane pane = new Pane();
        Text txt = new Text("Queste sono le tue medie");
        Scene scene = new Scene(pane,300,130);

        txt.setLayoutY(30);
        txt.setLayoutX(15);

        try {
            Stat s = BeanStats.averege();

            Button close = new Button("     Chiudi     ");
            String sTemp;
            String sTemp2;

            sTemp = String.valueOf(s.getPoints());
            sTemp2 = String.valueOf(s.getAssists());

            Text txt2 = new Text("Points: " + sTemp.substring(0,sTemp.indexOf(".") + 2) +
                    " Assists: " + sTemp2.substring(0,sTemp2.indexOf(".") + 2));


            sTemp = String.valueOf(s.getRebounds());
            sTemp2 = String.valueOf(s.getMinutes());

            Text txt3 = new Text(" Rebounds: " + sTemp.substring(0,sTemp.indexOf(".") + 2)  +
                    " Minutes: " + sTemp2.substring(0,sTemp2.indexOf(".") + 2) );

            close.setOnMouseEntered(mouseEvent -> close.setCursor(Cursor.HAND));
            close.setOnMouseExited(mouseEvent -> close.setCursor(Cursor.DEFAULT));
            close.setOnMouseClicked(mouseEvent -> stage.close());

            close.setLayoutY(90);
            close.setLayoutX(100);


            pane.getChildren().addAll(txt, txt2, txt3, close);

            txt2.setLayoutX(15);
            txt2.setLayoutY(50);

            txt3.setLayoutX(15);
            txt3.setLayoutY(70);

        } catch (MyException e) {
            txt.setText("An error occurred!");
            pane.getChildren().add(txt);
        }


        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void add() {
        try {
            BeanStats.add(points.getText(), assists.getText(), rebounds.getText(), minutes.getText());
            returnText.setText("*Statistica aggiunta con successo");
            returnText.setStyle("-fx-fill: GREEN");
            returnText.toFront();
        } catch (Exception e) {
            returnText.setText("*Wrong input");
            returnText.setStyle("-fx-fill: RED");
            returnText.toFront();
        }finally {
            points.setText("0");
            assists.setText("0");
            rebounds.setText("0");
            minutes.setText("0");
        }
    }

}
