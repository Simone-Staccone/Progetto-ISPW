package logic.other;

import errorlogic.MyException;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.bean.BeanCourt;
import logic.entity.Court;

import java.util.ArrayList;
import java.util.List;

/**
 * ScrollList specifica per la gestione dei campetti
 */
public class CourtScrollList implements ScrollList{
    @Override
    public List<HBox> getList() throws MyException {
        List<Court> crt = BeanCourt.get();
        List<HBox> bList = new ArrayList<>();
        Court c;
        HBox b;

        for (Court court : crt) {
            c = court;
            b = new HBox(new Text(c.getName()));
            b.setMinHeight(40);
            b.setBorder(new Border(new BorderStroke(Color.valueOf("#FFA700"),
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            b.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(1),
                    new Insets(0.0, 0.0, 0.0, 0.0))));


            HBox finalB = b;
            b.setOnMouseEntered(event -> {
                finalB.setBorder(new Border(new BorderStroke(Color.WHITE,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                finalB.setCursor(Cursor.HAND);
            });


            HBox finalB1 = b;
            b.setOnMouseExited(event -> {
                finalB1.setBorder(new Border(new BorderStroke(Color.valueOf("#FFA700"),
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                finalB1.setCursor(Cursor.DEFAULT);
            });
            bList.add(b);
        }

        return bList;
    }
}
