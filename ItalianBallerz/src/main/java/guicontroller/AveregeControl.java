package guicontroller;

import errorlogic.MyException;
import logic.bean.BeanStats;
import logic.entity.Stat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Math.min;


/**
 * Questa classe ha la responsabilità di mostrare la media delle statistiche di un utente.
 * Mostra anche un grafico con l'andamento passato di tutte le statistiche avute.
 */
public class AveregeControl extends GenericInterface implements Initializable {
    @FXML
    private Text pointsText;
    @FXML
    private Text assistsText;
    @FXML
    private Text minutesText;
    @FXML
    private Text reboundsText;
    @FXML
    private AnchorPane centralPane;
    @FXML
    private Text errorText;

    /**
     * L'inizializzazione consiste nel tentare di recuperare i dati dell'utente.
     * Se questo avviene con successo si mostra media e grafico.
     * Altrimenti si avrà un messaggio di errore a schermo.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Stat s = BeanStats.averege();
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
        } catch (MyException e) {
            errorText.toFront();
        }


        try{
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            final AreaChart<Number,Number> ac =
                    new AreaChart<>(xAxis, yAxis);
            AnchorPane chartPane = new AnchorPane();
            ac.setTitle("Your stats");
            List<Stat> stlst;
            stlst = BeanStats.getStatsList();

            XYChart.Series seriesPoints = new XYChart.Series();
            seriesPoints.setName("Points");

            for(int i = 0;i<stlst.size();i++)
            {
                 seriesPoints.getData().add(new XYChart.Data(i, stlst.get(i).getPoints()));
            }

            XYChart.Series seriesAssists = new XYChart.Series();
            seriesAssists.setName("Assists");

            for(int i = 0;i<stlst.size();i++)
            {
                seriesAssists.getData().add(new XYChart.Data(i,stlst.get(i).getAssists()));
            }

            XYChart.Series seriesRebounds = new XYChart.Series();
            seriesRebounds.setName("Rebounds");

            for(int i = 0;i<stlst.size();i++)
            {
                seriesRebounds.getData().add(new XYChart.Data(i,stlst.get(i).getRebounds()));
            }

            XYChart.Series seriesMinutes = new XYChart.Series();
            seriesMinutes.setName("Minutes");

            for(int i = 0;i<stlst.size();i++)
            {
                seriesMinutes.getData().add(new XYChart.Data(i,stlst.get(i).getMinutes()));
            }


            ac.getData().addAll(seriesPoints, seriesAssists, seriesRebounds,seriesMinutes);

            chartPane.getChildren().add(ac);
            chartPane.setLayoutX(360);
            chartPane.setLayoutY(260);

            centralPane.getChildren().add(chartPane);

        }catch(MyException e){
            errorText.toFront();
        }
    }
}
