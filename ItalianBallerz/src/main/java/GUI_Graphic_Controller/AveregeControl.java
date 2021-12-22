package GUI_Graphic_Controller;


import Logic.Control.StatsController;
import Logic.Entity.Stat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.min;

public class AveregeControl extends GenericInterface implements Initializable {
    @FXML
    private Text pointsText;
    @FXML
    private Text assistsText;
    @FXML
    private Text minutesText;
    @FXML
    private Text reboundsText;


/*
        grafico.setTitle("Titolo");


        XYChart.Series seriesApril= new XYChart.Series();
        seriesApril.setName("April");
        seriesApril.getData().add(new XYChart.Data(1, 4));
        seriesApril.getData().add(new XYChart.Data(3, 10));
        seriesApril.getData().add(new XYChart.Data(6, 15));
        seriesApril.getData().add(new XYChart.Data(9, 8));
        seriesApril.getData().add(new XYChart.Data(12, 5));
        seriesApril.getData().add(new XYChart.Data(15, 18));
        seriesApril.getData().add(new XYChart.Data(18, 15));
        seriesApril.getData().add(new XYChart.Data(21, 13));
        seriesApril.getData().add(new XYChart.Data(24, 19));
        seriesApril.getData().add(new XYChart.Data(27, 21));
        seriesApril.getData().add(new XYChart.Data(30, 21));

        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("May");
        seriesMay.getData().add(new XYChart.Data(1, 20));
        seriesMay.getData().add(new XYChart.Data(3, 15));
        seriesMay.getData().add(new XYChart.Data(6, 13));
        seriesMay.getData().add(new XYChart.Data(9, 12));
        seriesMay.getData().add(new XYChart.Data(12, 14));
        seriesMay.getData().add(new XYChart.Data(15, 18));
        seriesMay.getData().add(new XYChart.Data(18, 25));
        seriesMay.getData().add(new XYChart.Data(21, 25));
        seriesMay.getData().add(new XYChart.Data(24, 23));
        seriesMay.getData().add(new XYChart.Data(27, 26));
        seriesMay.getData().add(new XYChart.Data(31, 26));


        //grafico.getData().addAll(seriesApril, seriesMay);

*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            StatsController st = new StatsController();
            Stat s = st.average();
            String temp;
            temp = Float.toString(s.getPoints());
            temp = temp.substring(0,min(temp.length(),4));
            pointsText.setText(temp);

            temp = Float.toString(s.getAssists());
            temp = temp.substring(0,min(temp.length(),4));

            assistsText.setText(temp);

            temp = Float.toString(s.getRebounds());
            temp = temp.substring(0,min(temp.length(),4));

            reboundsText.setText(temp);

            temp = Float.toString(s.getMinutes());
            temp = temp.substring(0,min(temp.length(),4));

            minutesText.setText(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
