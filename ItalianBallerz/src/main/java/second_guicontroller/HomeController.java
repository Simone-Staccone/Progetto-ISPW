package second_guicontroller;

import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.bean.BeanLogin;
import logic.other.Swap2;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller grafico della form relativa alla pagina di Home
 */
public class HomeController extends GenericInterface {
    private static List<String> nuovi = new ArrayList<>();

    @FXML
    private void swaptoStatForm(){
        Swap2.goTo("StatsForm.fxml",mainPane);
    }
    @FXML
    private void swaptoCourtForm(){
        Swap2.goTo("CourtForm.fxml",mainPane);
    }
    @FXML
    private void tryswaptoCourtAdd(){
        boolean b = false;
        if(BeanLogin.getUsername() != null)
        {
            b = BeanLogin.isOwner();
        }

        if(b){
            Swap2.goTo("CourtAdd.fxml",mainPane);
        }
        else
        {
            HomeController hc = new HomeController();
            Stage stage = hc.newWindow("Solo i propietari possono aggiungere nuovi campetti");
            Pane pane = (Pane)stage.getScene().getRoot();

            Button close = new Button("Chiudi");

            try{
                close.setLayoutX(120);
                close.setLayoutY(70);

                close.setOnMouseEntered(mouseEvent -> close.setCursor(Cursor.HAND));
                close.setOnMouseExited(mouseEvent -> close.setCursor(Cursor.DEFAULT));
                close.setOnMouseClicked(mouseEvent -> stage.close());

                pane.getChildren().add(close);
            } catch (Exception e) {
                pane.getChildren().add(new Text("Errore per aggiungere"));
            }


            stage.show();
        }
    }

    private Stage newWindow(String s) {
        Stage stage = new Stage();
        Pane pane = new Pane();

        Scene scene = new Scene(pane,300,100);

        Text txt = new Text(s);

        try {
            txt.setLayoutY(30);
            txt.setLayoutX(15);

            pane.setMinSize(300, 100);

            pane.getChildren().add(txt);


        } catch (Exception e) {
            pane.getChildren().add(new Text("Errore"));
        }

        stage.setResizable(false);
        stage.setScene(scene);

        return stage;
    }

    @FXML
    private void logout(){
        HomeController hc = new HomeController();
        Stage stage = hc.newWindow("Sei sicuro di voler uscire?");
        Pane pane = (Pane)stage.getScene().getRoot();


        Button bYes = new Button("     Yes     ");
        Button bNo = new Button("      No     ");

        try {
            bYes.setLayoutY(60);
            bYes.setLayoutX(60);


            bNo.setLayoutY(60);
            bNo.setLayoutX(160);


            bYes.setOnMouseEntered(mouseEvent -> bYes.setCursor(Cursor.HAND));
            bYes.setOnMouseExited(mouseEvent -> bYes.setCursor(Cursor.DEFAULT));
            bYes.setOnMouseClicked(mouseEvent -> {
                BeanLogin.logOut();
                stage.close();
                Swap2.goTo("LoginForm.fxml", mainPane);
            });

            bNo.setOnMouseEntered(mouseEvent -> bNo.setCursor(Cursor.HAND));
            bNo.setOnMouseExited(mouseEvent -> bNo.setCursor(Cursor.DEFAULT));
            bNo.setOnMouseClicked(mouseEvent -> stage.close());


            pane.getChildren().addAll(bYes, bNo);
        } catch (Exception e) {
            pane.getChildren().add(new Text("Errore per il bottone yes o no"));
        }
        stage.setTitle("Log Out");
        stage.setResizable(false);

        stage.show();
    }

    @FXML
    private void visualize(){
        boolean b = false;
        if(BeanLogin.getUsername() != null)
        {
            b = BeanLogin.isOwner();
        }

        if(b){
            Stage stage = new Stage();
            Pane pane = new Pane();
            Scene scene = new Scene(pane,400,500);
            Text text = new Text();
            ListView listView = new ListView();


            if(nuovi.isEmpty())
                text.setText("Non ci sono nuove prenotazioni");
            else
            {
                text.setText("Queste sono le nuove prenotazioni");

                for(int i = 0;i< nuovi.size();i=i+4)
                {
                    listView.getItems().add(nuovi.get(i) + " " + nuovi.get(i+1) + " " + nuovi.get(i+2) + " " + nuovi.get(i+3));
                }
                nuovi.clear();
            }


            pane.getChildren().add(listView);
            pane.getChildren().add(text);


            listView.prefHeight(20);
            listView.prefWidth(1000);

            listView.setLayoutX(30);
            listView.setLayoutY(50);

            text.setLayoutX(30);
            text.setLayoutY(20);


            stage.setTitle("Nuove prenotazioni");
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            HomeController hc = new HomeController();
            Stage stage = hc.newWindow("Solo i propietari possono visualizzare le prenotazioni");
            Pane pane = (Pane)stage.getScene().getRoot();

            try{
                Button close = new Button("Chiudi");
                pane.getChildren().add(close);

                close.setOnMouseEntered(mouseEvent -> close.setCursor(Cursor.HAND));
                close.setOnMouseExited(mouseEvent -> close.setCursor(Cursor.DEFAULT));
                close.setOnMouseClicked(mouseEvent -> stage.close());

                close.setLayoutX(120);
                close.setLayoutY(70);

            } catch (Exception e) {
                pane.getChildren().add(new Text("Errore per il bottone close"));
            }
            stage.show();
        }
    }


    public void notify(String owner, String location, String name, String start) {
        nuovi.add(owner);
        nuovi.add(location);
        nuovi.add(name);
        nuovi.add("Orario: " + start + ":00");
    }
}
