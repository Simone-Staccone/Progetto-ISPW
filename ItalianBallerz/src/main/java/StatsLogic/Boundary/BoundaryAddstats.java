package StatsLogic.Boundary;


import StatsLogic.Bean.BeanStats1;

import java.io.IOException;


public class BoundaryAddstats {
    public static void main(String[] arg) throws IOException {
        String po;
        String ass;
        String reb;
        String min;



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
