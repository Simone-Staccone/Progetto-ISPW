package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;



public class PlaygroundShowInterfaceController extends GenericInterface{
    @FXML
    public ImageView userIcon;
    @FXML
    public Label homeLabel;
    @FXML
    public Label statsLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public TextField serachList;

    private final boolean first = true;

    @FXML
    public void tryClear()
    {
        if(first)
        {
            serachList.setText("");
        }
    }

    @FXML
    public void PassOnInstance(){
        super.PassOn(userIcon,null);
    }
    @FXML
    public void PassOffInstance(){
        super.PassOff(userIcon,null);
    }

    @FXML
    public void PassOnP(){
        super.PassOn(null,playgroundLabel);
    }
    @FXML
    public void PassOffP(){
        super.PassOff(null,playgroundLabel);
    }

    @FXML
    public void PassOnS(){
        super.PassOn(null,statsLabel);
    }
    @FXML
    public void PassOffS(){
        super.PassOff(null,statsLabel);
    }



    @FXML
    public void PassOnH(){
        super.PassOn(null,homeLabel);
    }
    @FXML
    public void PassOffH(){
        super.PassOff(null,homeLabel);
    }


}
