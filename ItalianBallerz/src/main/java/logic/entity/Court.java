package logic.entity;

public class Court {
    private String name;
    public Court(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }
}
