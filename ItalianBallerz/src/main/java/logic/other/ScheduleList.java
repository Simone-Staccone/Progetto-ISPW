package logic.other;

import errorlogic.MyException;
import guicontroller.CourtController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * ScrollList specifica per la gestione dello schedule
 */
public class ScheduleList implements ScrollList{
    @Override
    public List<HBox> getList() throws MyException {
        List<HBox> bList = new ArrayList<>();
        HBox b;

        for(int i = 0;i<24;i++){
            Pane p = new Pane();
            Text t = new Text("   " + i + ":00 - " + (i+1) + ":00" + "\t\t");
            b = new HBox(t);

            p.setMinWidth(350);
            b.getChildren().add(p);
            bList.add(b);


            b.setMinHeight(40);
            b.setBorder(new Border(new BorderStroke(Color.valueOf("#FFA700"),
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            b.setBackground(new Background(new BackgroundFill(Color.WHITE, null,
                    null)));

            Button btn = new Button("Prenota");


            int finalI = i;
            btn.setOnMouseClicked(event -> {
                CourtController cc = new CourtController();
                cc.confirmWindow(finalI,t);
            });


            btn.setOnMouseEntered(event -> btn.setCursor(Cursor.HAND));
            btn.setOnMouseExited(event -> btn.setCursor(Cursor.DEFAULT));

            b.getChildren().add(btn);
        }

        return bList;
    }
}
