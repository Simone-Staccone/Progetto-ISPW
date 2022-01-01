package gui_Graphic_Controller;

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
    public AnchorPane mainPane;
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
    private void passOnInstance(){
        this.passOn(userIcon,null);
    }
    @FXML
    private void passOffInstance(){
        this.passOff(userIcon,null);
    }
    @FXML
    protected void PassOnS(){
        this.passOn(null,statsLabel);
    }
    @FXML
    protected void PassOffS(){
        this.passOff(null,statsLabel);
    }
    @FXML
    protected void PassOnP(){
        passOn(null,playgroundLabel);
    }
    @FXML
    protected void PassOffP(){
        passOff(null,playgroundLabel);
    }
    @FXML
    protected void PassOnH(){
        passOn(null,homeLabel);
    }
    @FXML
    protected void PassOffH(){
        passOff(null,homeLabel);
    }
    @FXML
    private void passOn(ImageView img, Label label) {
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
    private void passOff(ImageView img, Label label) {
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
    protected void genericEnter()
    {
        mainPane.setCursor(Cursor.HAND);
    }

    @FXML
    protected void genericExit()
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
    }

    @FXML
    protected void SwaptoR()  {
        Swap.goTo("RegisterInterface.fxml",mainPane);
    }
}


