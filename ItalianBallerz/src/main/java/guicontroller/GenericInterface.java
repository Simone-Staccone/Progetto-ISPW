package guicontroller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.other.Swap;
import logic.other.Swap2;


/**
 * Classe che ha la responsabilità di fornire funzioni a tutti i controller grafici che sono ricorrenti e riutilizzabili,
 */
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
    protected void passOnS(){
        this.passOn(null,statsLabel);
    }
    @FXML
    protected void passOffS(){
        this.passOff(null,statsLabel);
    }
    @FXML
    protected void passOnP(){
        passOn(null,playgroundLabel);
    }
    @FXML
    protected void passOffP(){
        passOff(null,playgroundLabel);
    }
    @FXML
    protected void passOnH(){
        passOn(null,homeLabel);
    }
    @FXML
    protected void passOffH(){
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
    protected void swaptoH(){
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
    protected void swaptoP(){
        Swap.goTo("PlaygroundShowInterface.fxml",mainPane);
    }

    @FXML
    protected void swaptoS(){
        Swap.goTo("StatsInterfaceUse.fxml",mainPane);
    }

    @FXML
    protected void swaptoL(){
        Swap.goTo("LoginInterface.fxml",mainPane);
    }
    @FXML
    protected void swaptoA(){
        Swap.goTo("AveregeStats.fxml",mainPane);
    }

    @FXML
    protected void swaptoS2(){
        Swap.goTo("MyStatsInterface.fxml",mainPane);
    }

    @FXML
    protected void swaptoR()  {
        Swap.goTo("RegisterInterface.fxml",mainPane);
    }

    @FXML
    protected void swapto1(){Swap.goTo("MainInterface.fxml",mainPane);}

    @FXML
    protected void swaptoC(){
        Swap.goTo("ChooseController.fxml",mainPane);
    }

    @FXML
    protected void swapto2(){
        Swap2.goTo("LoginForm.fxml",mainPane);
    }

    @FXML
    private void close(){
        Stage stage = (Stage)mainPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void swaptoHome(){
        Swap2.goTo("Home.fxml",mainPane);
    }
}


