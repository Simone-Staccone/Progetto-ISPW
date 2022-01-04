package logic.other;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.entity.Court;
import logic.entity.CourtList;

import java.util.ArrayList;
import java.util.List;

public class CourtScrollList implements ScrollList{
    @Override
    public List<HBox> getList(String name) {
        CourtList crt = new CourtList(name);
        List<HBox> bList = new ArrayList<>();
        Court c;
        HBox b;

        for(int i = 0;i<crt.size();i++){
            c = crt.get(i);
            b = new HBox(new Text(c.getName()));
            try{
                b.setMinHeight(40);
                b.setBorder(new Border(new BorderStroke(Color.valueOf("#FFA700"),
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                b.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(1),
                        new Insets(0.0, 0.0, 0.0, 0.0))));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
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
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(c != null){
                bList.add(b);
            }
        }

        return bList;
    }
}