package GUI_Graphic_Controller;

import Logic.Other.Swap;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;



public class  GenericInterface {
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Pane userIconPane;
    @FXML
    private ImageView userIcon;
    @FXML
    public Label homeLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public Label statsLabel;

    @FXML
    private void PassOnInstance(){
        this.PassOn(userIcon,null);
    }
    @FXML
    private void PassOffInstance(){
        this.PassOff(userIcon,null);
    }
    @FXML
    protected void PassOnS(){
        this.PassOn(null,statsLabel);
    }
    @FXML
    protected void PassOffS(){
        this.PassOff(null,statsLabel);
    }
    @FXML
    protected void PassOnP(){
        PassOn(null,playgroundLabel);
    }
    @FXML
    protected void PassOffP(){
        PassOff(null,playgroundLabel);
    }
    @FXML
    protected void PassOnH(){
        PassOn(null,homeLabel);
    }
    @FXML
    protected void PassOffH(){
        PassOff(null,homeLabel);
    }
    @FXML
    private void PassOn(ImageView img, Label label) {
        if (img != null) {
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(+0.5);
            img.setEffect(colorAdjust);
            userIconPane.setCursor(Cursor.HAND);
        } else if (label != null) {
            label.setTextFill(Color.GREY);
            label.setCursor(Cursor.HAND);
        }
    }

    @FXML
    private void PassOff(ImageView img, Label label) {
        if (img != null) {
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(-0.5);
            img.setEffect(colorAdjust);
            userIconPane.setCursor(Cursor.DEFAULT);
        }
        else if (label != null) {
            label.setTextFill(Color.BLACK);
            label.setCursor(Cursor.DEFAULT);
        }
    }



    @FXML
    protected void SwaptoH(){
        Swap.goTo("MainInterface.fxml",mainPane);
    }


    @FXML
    protected void GenericEnter()
    {
        mainPane.setCursor(Cursor.HAND);
    }

    @FXML
    protected void GenericExit()
    {
        mainPane.setCursor(Cursor.DEFAULT);
    }

    @FXML
    protected void SwaptoP(){
        Swap.goTo("PlaygroundShowInterface.fxml",mainPane);
    }

    @FXML
    protected void SwaptoS(){
        Swap.goTo("StatsInterfaceUse.fxml",mainPane);
    }

    @FXML
    protected void SwaptoL(){
        Swap.goTo("LoginInterface.fxml",mainPane);
    }
    @FXML
    protected void SwaptoA(){
        Swap.goTo("AveregeStats.fxml",mainPane);
    }

    @FXML
    protected void SwaptoS2(){
        Swap.goTo("MyStatsInterface.fxml",mainPane);
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
    protected void SwaptoR()  {
        Swap.goTo("RegisterInterface.fxml",mainPane);
    }
}


