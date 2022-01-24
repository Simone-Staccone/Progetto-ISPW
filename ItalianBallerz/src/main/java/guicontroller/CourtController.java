package guicontroller;


import errorlogic.NotLoggedException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.bean.BeanCourt;
import logic.other.FactoryScrollList;
import logic.other.ScrollList;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CourtController extends GenericInterface implements Initializable {
    @FXML
    private Text label;
    @FXML
    private Text owner;
    @FXML
    private Text phone;
    @FXML
    private Text money;
    @FXML
    private Text location;
    @FXML
    private VBox scrollList;
    @FXML
    private AnchorPane container;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScrollList scL;
        List<HBox> bList = null;


        label.setText(BeanCourt.getCurrentName());
        owner.setText(BeanCourt.getCurrentOwner());
        money.setText(BeanCourt.getCurrentMoney());
        phone.setText(BeanCourt.getCurrentPhone());
        location.setText(BeanCourt.getCurrentLocation());

        FactoryScrollList factory = new FactoryScrollList();

        try {
            scL = factory.createList(3);
            bList = scL.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            container.setMinHeight(bList.size()*40);
            for (HBox hBox : bList)
                scrollList.getChildren().add(hBox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waringMessage() {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Text txt = new Text("Log in necessario!");

        txt.setLayoutY(30);
        txt.setLayoutX(80);
        txt.setFont(Font.font(txt.getFont().getName(), 18));



        Button btn = new Button("Chiudi");
        btn.setOnMouseEntered(event -> btn.setCursor(Cursor.HAND));
        btn.setOnMouseExited(event -> btn.setCursor(Cursor.DEFAULT));
        btn.setOnMouseClicked(event -> stage.close());

        btn.setLayoutY(60);
        btn.setLayoutX(120);
        btn.setFont(Font.font(txt.getFont().getName(), 14));

        Scene scene = new Scene(pane,300,100);

        pane.getChildren().addAll(txt,btn);
        stage.setResizable(false);
        stage.setTitle("WARING!!!");
        stage.setScene(scene);
        stage.show();
    }

    public void confirmWindow(int i,Text t) {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle(t.getText().substring(0,t.getText().indexOf("\t")));

        Pane p1 = new Pane();
        Button yes = new Button("     Yes     ");
        Button no = new Button("      No     ");
        Text txt = new Text("  Sei sicuro di voler prenotare?");


        yes.setOnMouseEntered(mouseEvent -> yes.setCursor(Cursor.HAND));
        yes.setOnMouseExited(mouseEvent -> yes.setCursor(Cursor.DEFAULT));
        yes.setOnMouseClicked(mouseEvent ->
        {
            try {
                BeanCourt.addSchedule(i);
            } catch (NotLoggedException e) {
                CourtController cc = new CourtController();
                cc.waringMessage();
            }finally {
                stage.close();
            }
        });

        yes.setLayoutY(60);
        yes.setLayoutX(60);
        yes.setFont(Font.font(txt.getFont().getName(), 14));

        no.setOnMouseEntered(mouseEvent -> no.setCursor(Cursor.HAND));
        no.setOnMouseExited(mouseEvent -> no.setCursor(Cursor.DEFAULT));
        no.setOnMouseClicked(mouseEvent -> stage.close());

        no.setLayoutY(60);
        no.setLayoutX(160);
        no.setFont(Font.font(txt.getFont().getName(), 14));


        p1.getChildren().addAll(txt, yes, no);


        Scene scene = new Scene(p1,300,100);

        txt.setFont(Font.font(txt.getFont().getName(), 18));

        txt.setLayoutY(30);
        txt.setLayoutX(15);




        stage.setScene(scene);
        stage.show();
    }
}
