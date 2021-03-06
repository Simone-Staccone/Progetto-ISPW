package guicontroller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.bean.BeanLogin;
import logic.other.SingletonPlayer;
import logic.other.Swap;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller grafico che ha la responsabilit√† di gestire l'interfaccia grafica di gestione una volta eseguito il log in.
 */
public class LoggedInterfaceController extends GenericInterface implements Initializable {
    @FXML
    private Text text;
    @FXML
    private Text txt3;
    @FXML
    private AnchorPane box3;
    @FXML
    private Text txt4;
    @FXML
    private Circle notifyCircle;
    @FXML
    private Text counter;

    private static int notify = 0;
    private static List<String> names = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText(BeanLogin.getUsername());
        if(BeanLogin.isOwner()){
            txt3.setText("Aggiungi il tuo campetto");
            txt4.setText("Richieste di prenotazione");
            counter.setText(String.valueOf(notify));

            notifyCircle.setOnMouseClicked(event -> {
                LoggedInterfaceController lg = new LoggedInterfaceController();
                lg.reservations(names,counter);
            });

            box3.setOnMouseEntered(this::in);
            box3.setOnMouseExited(this::out);
            box3.setOnMouseClicked(mouseEvent -> Swap.goTo("AddPlayground.fxml",mainPane));
        }
        else
        {
            notifyCircle.toBack();
            counter.toBack();
        }
    }

    /**
     * La classe si occupa di mostrare le nuove prenotazioni se ce ne sono.
     * @param names array di stringhe relative alle nuove prenotazioni
     * @param counter numero di nuove notifiche in formato stringa
     */
    private static void reservations(List<String> names, Text counter) {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane,300,150);
        Text txt = new Text();

        pane.getChildren().add(txt);
        txt.setLayoutY(50);


        if(Integer.parseInt(counter.getText()) == 0)
        {
            txt.setText("Non ci sono nuove notifiche");
            txt.setLayoutX(20);
        }
        else
        {
            VBox b = new VBox();
            pane.getChildren().add(b);

            for(String s : names) {
                if(SingletonPlayer.getLoginInstance().getUsername().compareTo(s) == 0){
                    Text t = new Text(names.get(names.indexOf(s)+1) + " " + names.get(names.indexOf(s)+2));
                    b.getChildren().add(new HBox(t));
                    notify--;
                }
            }
            names.clear();
        }


        stage.setTitle("Nuove prenotazioni");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Serve per evidenziare il container sul cui passa il cursore.
     * @param e evento sul quale si genera il passiaggio del cursore
     */
    @FXML
    private void in(MouseEvent e)
    {
        AnchorPane p = (AnchorPane) e.getSource();
        p.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        p.setCursor(Cursor.HAND);
    }

    /**
     * Serve per far tornare allo stato normale il container una volta evidenziato.
     * @param e evento dal quale esce il cursore
     */
    @FXML
    private void out(MouseEvent e)
    {
        AnchorPane p = (AnchorPane) e.getSource();
        p.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        p.setCursor(Cursor.DEFAULT);
    }

    /**
     * Apre una finestra per confermare il logout.
     * Se la conferma avviene effettua il logout.
     */
    @FXML
    private void logOut() {
        Stage stage = new Stage();
        Pane pane = new Pane();
        pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(pane);
        Button bYes = new Button("     Yes     ");
        Button bNo = new Button("      No     ");
        Text txt = new Text("Sei sicuro di voler uscire?");

        try {
            txt.setLayoutY(30);
            txt.setLayoutX(15);
            txt.setFont(Font.font(txt.getFont().getName(), 18));

            pane.setMinSize(300, 100);

            bYes.setLayoutY(60);
            bYes.setLayoutX(60);
            bYes.setFont(Font.font(txt.getFont().getName(), 14));

            bNo.setLayoutY(60);
            bNo.setLayoutX(160);
            bNo.setFont(Font.font(txt.getFont().getName(), 14));

            bYes.setOnMouseEntered(mouseEvent -> bYes.setCursor(Cursor.HAND));
            bYes.setOnMouseExited(mouseEvent -> bYes.setCursor(Cursor.DEFAULT));
            bYes.setOnMouseClicked(mouseEvent -> {
                BeanLogin.logOut();
                stage.close();
                Swap.goTo("LoginInterface.fxml",mainPane);
            });

            bNo.setOnMouseEntered(mouseEvent -> bNo.setCursor(Cursor.HAND));
            bNo.setOnMouseExited(mouseEvent -> bNo.setCursor(Cursor.DEFAULT));
            bNo.setOnMouseClicked(mouseEvent -> stage.close());

            pane.getChildren().addAll(txt, bYes, bNo);

            stage.setScene(scene);
            stage.setTitle("Log Out");
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            txt.setText("Trovato un errore");
        }
    }

    /**
     * La classe si occupa di fare l'update delle nuove prenotazioni.
     * @param owner proprietario del campetto
     * @param location citt√† in cui si trova il campetto
     * @param name nome del campetto
     */
    public static void notify(String owner, String location, String name) {
        names.add(owner);
        names.add(location);
        names.add(name);
        notify++;
    }
}

