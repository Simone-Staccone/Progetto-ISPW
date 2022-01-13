package logic.other;


import errorlogic.MyException;


public class FactoryScrollList{
    public ScrollList createList(int type) throws MyException {
        switch (type) {
            case 1:
                return statsList();
            case 2:
                return courtList();
            default:
                throw new MyException("Invalid type : " + type,null);
        }
    }

    public ScrollList statsList(){
        return new ScrollListStats();
    }

    public ScrollList courtList(){
        return new CourtScrollList();
    }

}
