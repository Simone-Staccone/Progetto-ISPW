package StatsLogic.Boundary;


import GUI.MainInterface;
import GUI.StatsInterface;
import StatsLogic.Bean.BeanStats1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class BoundaryAddstats {
    public static void main(String[] arg) throws IOException {
        String po;
        String ass;
        String reb;
        String min;

        StatsInterface.tryLaunch();

        /*
        System.out.println("Insert points:");
        Scanner sc= new Scanner(System.in);
        po = sc.nextLine();
        System.out.println("Insert assists:");
        ass = sc.nextLine();
        System.out.println("Insert rebounds:");
        reb = sc.nextLine();
        System.out.println("Insert minutes:");
        min = sc.nextLine();

        BoundaryAddstats.addStats(po,ass,reb,min);
         */
    }


    public static void addStats(String points, String assists, String rebounds, String minutes) throws IOException {
        BeanStats1.add(points,assists,rebounds,minutes);
    }

    public void getStats()
    {

    }

    public static void showM(String s){
        System.out.println("Interaction returned: " + s);
    }
}
