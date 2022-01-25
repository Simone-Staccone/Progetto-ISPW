package guicontroller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class MainInterfaceController extends GenericInterface{
    @FXML
    private Pane playgroundImagePane;
    @FXML
    private Pane statsImagePane;

    @FXML
    private void highlightOn(Pane pane){
        pane.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
        pane.toFront();
        pane.getScene().setCursor(Cursor.HAND);
    }

    @FXML
    private void highlightOff(Pane pane){
        pane.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
        pane.toFront();
        pane.getScene().setCursor(Cursor.DEFAULT);
    }

    @FXML
    public void highlightOnL(){
        this.highlightOn(playgroundImagePane);
    }
    @FXML
    public void highlightOffL(){
        this.highlightOff(playgroundImagePane);
    }

    @FXML
    public void highlightOnD(){
        this.highlightOn(statsImagePane);
    }
    @FXML
    public void highlightOffD(){
        this.highlightOff(statsImagePane);
    }

}

