package guicontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Questa è la entry principale del sistema. Appena entrato si farà scegliere quale interfaccia utilizzare.
 * Il sistema ha come funzionalità principali quella di cercare e prenotare un campetto, oppure di salvare
 * le proprie statistiche.
 * Questa classe ha la responsabilità di caricare la prima pagina fxml per far partire il programma.
 */
public class MainInterface extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader xml =  new FXMLLoader(MainInterface.class.getResource("ChooseController.fxml"));
        Scene scene = new Scene(xml.load());
        stage.setResizable(false);
        stage.setTitle("Italian Ballerz");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}