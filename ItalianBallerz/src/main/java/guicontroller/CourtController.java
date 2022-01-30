package guicontroller;


import errorlogic.AlreadyReserved;
import errorlogic.NotLoggedException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.bean.BeanCourt;
import logic.other.FactoryScrollList;
import logic.other.ScrollList;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Questa classe ha la responsabilità di gestire le informazioni relative ad un campetto sdcelto.
 * Inoltre permette di prenotare uno slot dello schedule del campetto.
 */
public class CourtController extends GenericInterface implements Initializable {
    @FXML
    private Text label;
    @FXML
    private Text owner;
    @FXML
    private Text phone;
    @FXML
    private Text money;
    @FXML
    private Text location;
    @FXML
    private VBox scrollList;
    @FXML
    private AnchorPane container;


    /**
     * Nell'inizializzazione si prova a prendere le informazioni del campetto da sistema. Se tutto avviene correttamente
     * vengono mostrate, altrimenti si avrà un messaggio di errore a terminale in cui è scritta la traccia dello stack.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScrollList scL;
        List<HBox> bList;

        label.setText(BeanCourt.getCurrentName());
        owner.setText(BeanCourt.getCurrentOwner());
        money.setText(BeanCourt.getCurrentMoney());
        phone.setText(BeanCourt.getCurrentPhone());
        location.setText(BeanCourt.getCurrentLocation());

        FactoryScrollList factory = new FactoryScrollList();

        try {
            scL = factory.createList(3);
            bList = scL.getList();

            container.setMinHeight(bList.size()*40);
            for (HBox hBox : bList)
                scrollList.getChildren().add(hBox);
        } catch (Exception e) {
            scrollList.getChildren().add(new HBox(new Text("Vuoto")));
        }
    }

    /**
     * La classe serve per fornire una finestra standard di errore.
     * @param message Cosa scrivere nella finestra
     * @param space Quanto spazio lasciare a sinistra del messaggio
     */
    public void waringMessage(String message,int space) {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Text txt = new Text(message);

        txt.setLayoutY(30);
        txt.setLayoutX(space);
        txt.setFont(Font.font(txt.getFont().getName(), 18));



        Button btn = new Button("Chiudi");
        btn.setOnMouseEntered(event -> btn.setCursor(Cursor.HAND));
        btn.setOnMouseExited(event -> btn.setCursor(Cursor.DEFAULT));
        btn.setOnMouseClicked(event -> stage.close());

        btn.setLayoutY(60);
        btn.setLayoutX(120);
        btn.setFont(Font.font(txt.getFont().getName(), 14));

        Scene scene = new Scene(pane,300,100);

        pane.getChildren().addAll(txt,btn);
        stage.setResizable(false);
        stage.setTitle("WARING!!!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * La classe serve per gestire la finestra di conferma di prenotazione di uno slot e quindi prova a prenotare.
     * @param i orario in cui prenotare
     * @param t titolo della finestra
     */
    public void confirmWindow(int i,Text t) {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle(t.getText().substring(0,t.getText().indexOf("\t")));

        Pane p1 = new Pane();
        Button yes = new Button("     Yes     ");
        Button no = new Button("      No     ");
        Text txt = new Text("  Sei sicuro di voler prenotare?");


        yes.setOnMouseEntered(mouseEvent -> yes.setCursor(Cursor.HAND));
        yes.setOnMouseExited(mouseEvent -> yes.setCursor(Cursor.DEFAULT));
        yes.setOnMouseClicked(mouseEvent ->
        {
            try {
                BeanCourt.addSchedule(i);
            } catch (NotLoggedException e) {
                CourtController cc = new CourtController();
                cc.waringMessage("Log in necessario!",80);
            } catch (FileNotFoundException f) {
                CourtController cc = new CourtController();
                cc.waringMessage("File non trovato",80);
            } catch (AlreadyReserved a) {
                CourtController cc = new CourtController();
                cc.waringMessage("Sei già prenotato in quest'orario!",30);
            } finally {
                stage.close();
            }
        });



        yes.setLayoutY(60);
        yes.setLayoutX(60);
        yes.setFont(Font.font(txt.getFont().getName(), 14));

        no.setOnMouseEntered(mouseEvent -> no.setCursor(Cursor.HAND));
        no.setOnMouseExited(mouseEvent -> no.setCursor(Cursor.DEFAULT));
        no.setOnMouseClicked(mouseEvent -> stage.close());

        no.setLayoutY(60);
        no.setLayoutX(160);
        no.setFont(Font.font(txt.getFont().getName(), 14));


        p1.getChildren().addAll(txt, yes, no);


        Scene scene = new Scene(p1,300,100);

        txt.setFont(Font.font(txt.getFont().getName(), 18));

        txt.setLayoutY(30);
        txt.setLayoutX(15);

        stage.setScene(scene);
        stage.show();
    }

}
