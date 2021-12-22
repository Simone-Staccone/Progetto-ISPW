package GUI_Graphic_Controller;

import Logic.Bean.BeanStats;
import Logic.Entity.Stat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;




public class MyStatsControl extends GenericInterface implements Initializable {
    @FXML
    private AnchorPane ancPane;
    @FXML
    private VBox box;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Stat> statList = BeanStats.getStatsList();
        Stat s;
        List<HBox> bList = new ArrayList<>();
        try{
            for (Stat stat : statList) {
                s = stat;
                HBox b = new HBox();
                bList.add(b);
                b.setMinHeight(40);
                b.getChildren().add(new Text("Points:  " + s.getPoints() +
                        "  Assists:  " + s.getAssists() +
                        "  Rebounds:  " + s.getRebounds() +
                        "  Minutes:  " + s.getMinutes()
                ));
                b.setBorder(new Border(new BorderStroke(Color.valueOf("#FFA700"),
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                b.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(1),
                        new Insets(0.0, 0.0, 0.0, 0.0))));
                try {
                    b.setOnMouseEntered(event -> {
                        b.setBorder(new Border(new BorderStroke(Color.WHITE,
                                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                        b.setCursor(Cursor.HAND);
                    });


                    b.setOnMouseExited(event -> {
                        b.setBorder(new Border(new BorderStroke(Color.valueOf("#FFA700"),
                                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                        b.setCursor(Cursor.DEFAULT);
                    });
                    try{
                        Pane pane = new Pane();
                        Stage stage = new Stage();
                        Button button = new Button();

                        button.setText("Delete");
                        button.setOnMouseClicked(event -> BeanStats.delete());

                        pane.getChildren().add(button);
                        Scene scene = new Scene(pane, 400, 200);
                        stage.setTitle("Stat " + statList.indexOf(s));
                        stage.setScene(scene);
                        b.setOnMouseClicked(event -> stage.show());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try{
            ancPane.setMinHeight(bList.size()*40);
            for(int i = 0;i<statList.size();i++){
                box.getChildren().add(bList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
