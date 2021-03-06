package logic.other;

import errorlogic.MyException;
import logic.bean.BeanStats;
import logic.entity.Stat;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ScrollList specifica per la gestione delle statistiche
 */
public class ScrollListStats implements ScrollList{
    @Override
    public List<HBox> getList() throws MyException{
        List<Stat> statList;
        statList = BeanStats.getStatsList();
        Stat s;
        List<HBox> bList = new ArrayList<>();

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
            Pane pane = new Pane();
            Stage stage = new Stage();
            Button button = new Button();

            button.setText("Delete");
            button.setLayoutX(170);
            button.setLayoutY(80);
            Stat finalS = s;
            button.setOnMouseClicked(event -> {
                try {
                    BeanStats.delete(statList.indexOf(finalS));
                } catch (IOException e) {
                    stage.setTitle("Non cancellato");
                }
                stage.close();
            });

            pane.getChildren().add(button);
            Scene scene = new Scene(pane, 400, 200);
            stage.setTitle("Stat " + statList.indexOf(s));
            stage.setScene(scene);
            stage.setResizable(false);
            b.setOnMouseClicked(event -> {
                stage.show();
                stage.toFront();
            });
        }

        return bList;
    }
}
