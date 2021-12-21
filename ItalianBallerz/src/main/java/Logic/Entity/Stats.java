package Logic.Entity;



public class Stats {
    private final float points;
    private final float assists;
    private final float rebounds;
    private final float minutes;

    public Stats(float points, float assists, float rebounds, float minutes){
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.minutes = minutes;
    }
    public float getPoints()
    {
        return this.points;
    }
    public float getAssists() {
        return this.assists;
    }
    public float getRebounds() {
        return this.rebounds;
    }
    public float getMinutes() {
        return this.minutes;
    }

}
