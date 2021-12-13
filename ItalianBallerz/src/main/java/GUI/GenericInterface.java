package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class  GenericInterface {
    protected boolean clicked = false;
    protected boolean logged = false;
    protected String UserLog = "";
    protected String UserPassw = "";

    @FXML
    public Pane blockPane;
    @FXML
    public Pane loginPane;
    @FXML
    public AnchorPane mainPane;
    @FXML
    public Pane userIconPane;
    @FXML
    public Pane topAnchorPane;
    @FXML
    public Label userLabel;
    @FXML
    public ImageView userIcon;



    @FXML
    public void PassOn(ImageView img, Label label) {
        if (img != null) {
            if (!clicked) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(+0.5);
                img.setEffect(colorAdjust);
                userIconPane.setCursor(Cursor.HAND);
            }
        } else if (label != null) {
            label.setTextFill(Color.GREY);
            label.setCursor(Cursor.HAND);
        }
    }

    @FXML
    public void PassOff(ImageView img, Label label) {
        if (img != null) {
            if (!clicked) {
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setBrightness(-0.5);
                img.setEffect(colorAdjust);
                userIconPane.setCursor(Cursor.DEFAULT);
            }
        } else if (label != null) {
            label.setTextFill(Color.BLACK);
            label.setCursor(Cursor.DEFAULT);
        }
    }




    @FXML
    public void Login(String Username, String Password) throws IOException {
        mainPane.getChildren().remove(loginPane);
        userIconPane.getChildren().remove(userIcon);
        mainPane.getChildren().remove(userIconPane);
        userLabel = new Label(Username + " " + Password);
        mainPane.getChildren().add(userLabel);
        UserLog = Username;
        UserPassw = Password;
        logged = true;
    }


    @FXML
    public void BringUP(ImageView img) {
        if (!clicked) {
            loginPane.toFront();
            clicked = true;
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(+0.5);
            img.setEffect(colorAdjust);
        } else {
            blockPane.toFront();
            clicked = false;
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(-0.5);
            img.setEffect(colorAdjust);
        }
    }

    @FXML
    public void SwaptoH() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("MainInterface.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage)mainPane.getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    @FXML
    public void SwaptoP() throws IOException {
        Parent parent = FXMLLoader.load(PlaygroundInterfaceController.class.getResource("PlaygroundInterface.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage)mainPane.getScene().getWindow();
        window.setScene(scene);
        window.show();
        if(logged) {
            System.out.println("Esegui");
            mainPane.getChildren().remove(loginPane);
            mainPane.getChildren().remove(userIcon);
            mainPane.getChildren().remove(userIconPane);
        }
    }

    @FXML
    public void SwaptoS() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StatsInterface.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage)mainPane.getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void SwaptoR() throws IOException {
        Parent parent = FXMLLoader.load(MainInterface.class .getResource("RegisterInterface.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage)mainPane.getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void HighlightOn(Pane pane){
        pane.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
        pane.toFront();
        pane.getScene().setCursor(Cursor.HAND);
    }

    @FXML
    public void HighlightOff(Pane pane){
        pane.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
        pane.toFront();
        pane.getScene().setCursor(Cursor.DEFAULT);
    }
}


