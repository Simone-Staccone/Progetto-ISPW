package GUI_Graphic_Controller;

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
    private void HighlightOn(Pane pane){
        pane.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
        pane.toFront();
        pane.getScene().setCursor(Cursor.HAND);
    }

    @FXML
    private void HighlightOff(Pane pane){
        pane.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10))));
        pane.toFront();
        pane.getScene().setCursor(Cursor.DEFAULT);
    }

    @FXML
    public void HighlightOnL(){
        this.HighlightOn(playgroundImagePane);
    }
    @FXML
    public void HighlightOffL(){
        this.HighlightOff(playgroundImagePane);
    }

    @FXML
    public void HighlightOnD(){
        this.HighlightOn(statsImagePane);
    }
    @FXML
    public void HighlightOffD(){
        this.HighlightOff(statsImagePane);
    }

}

