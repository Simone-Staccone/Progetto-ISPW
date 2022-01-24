package logic.other;


import errorlogic.MyException;


public class FactoryScrollList{
    public ScrollList createList(int type) throws MyException {
        switch (type) {
            case 1:
                return statsList();
            case 2:
                return courtList();
            case 3:
                return scheduleList();
            default:
                throw new MyException("Invalid type : " + type,null);
        }
    }

    private ScrollList scheduleList() {
        return new ScheduleList();
    }

    public ScrollList statsList(){
        return new ScrollListStats();
    }

    public ScrollList courtList(){
        return new CourtScrollList();
    }

}
