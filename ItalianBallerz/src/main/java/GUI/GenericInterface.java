package GUI;

import StatsLogic.Boundary.ControlView.Swap;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
    public AreaChart grafico;


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
    public void SwaptoH(){
        Swap.goTo("MainInterface.fxml",mainPane);
    }


    @FXML
    public void GenericEnter()
    {
        mainPane.setCursor(Cursor.HAND);
    }

    @FXML
    public void GenericExit()
    {
        mainPane.setCursor(Cursor.DEFAULT);
    }

    @FXML
    public void SwaptoP(){
        Swap.goTo("PlaygroundShowInterface.fxml",mainPane);
        if(logged) {
            System.out.println("Esegui");
            mainPane.getChildren().remove(loginPane);
            mainPane.getChildren().remove(userIcon);
            mainPane.getChildren().remove(userIconPane);
        }
    }

    @FXML
    public void SwaptoS(){
        Swap.goTo("StatsInterfaceUse.fxml",mainPane);
    }

    @FXML
    public void SwaptoL(){
        Swap.goTo("LoginInterface.fxml",mainPane);
    }

    @FXML
    public void SwapToS2(Event e){
        Swap.goTo("AveregeStats.fxml",mainPane);
/*
        XYChart.Series seriesApril= new XYChart.Series();
        seriesApril.setName("April");
        seriesApril.getData().add(new XYChart.Data(1, 4));
        seriesApril.getData().add(new XYChart.Data(3, 10));
        seriesApril.getData().add(new XYChart.Data(6, 15));
        seriesApril.getData().add(new XYChart.Data(9, 8));
        seriesApril.getData().add(new XYChart.Data(12, 5));
        seriesApril.getData().add(new XYChart.Data(15, 18));
        seriesApril.getData().add(new XYChart.Data(18, 15));
        seriesApril.getData().add(new XYChart.Data(21, 13));
        seriesApril.getData().add(new XYChart.Data(24, 19));
        seriesApril.getData().add(new XYChart.Data(27, 21));
        seriesApril.getData().add(new XYChart.Data(30, 21));

        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("May");
        seriesMay.getData().add(new XYChart.Data(1, 20));
        seriesMay.getData().add(new XYChart.Data(3, 15));
        seriesMay.getData().add(new XYChart.Data(6, 13));
        seriesMay.getData().add(new XYChart.Data(9, 12));
        seriesMay.getData().add(new XYChart.Data(12, 14));
        seriesMay.getData().add(new XYChart.Data(15, 18));
        seriesMay.getData().add(new XYChart.Data(18, 25));
        seriesMay.getData().add(new XYChart.Data(21, 25));
        seriesMay.getData().add(new XYChart.Data(24, 23));
        seriesMay.getData().add(new XYChart.Data(27, 26));
        seriesMay.getData().add(new XYChart.Data(31, 26));

        Scene scene  = new Scene(ac,800,600);
        ac.getData().addAll(seriesApril, seriesMay);*/
    }

    @FXML
    public void SwaptoR() throws IOException {
        Swap.goTo("RegisterInterface.fxml",mainPane);
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


