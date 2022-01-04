package logic.other;


import logic.entity.CourtList;

public class FactoryScrollList{
    public ScrollList createList(int type) throws Exception {
        switch (type) {
            case 1:
                return statsList();
            case 2:
                return courtList();
            default:
                throw new Exception("Invalid type : " + type);
        }
    }

    public ScrollList statsList(){
        return new ScrollListStats();
    }

    public ScrollList courtList(){
        return new CourtScrollList();
    }

}
