package logic.other;


public class FactoryScrollList{
    public ScrollList createList(int type) throws Exception {
        switch (type) {
            case 1:
                return statsList();
            default:
                throw new Exception("Invalid type : " + type);
        }
    }

    public ScrollList statsList(){
        return new ScrollListStats();
    }

}