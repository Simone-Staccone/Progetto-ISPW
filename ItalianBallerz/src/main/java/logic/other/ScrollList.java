package logic.other;

import errorlogic.MyException;
import javafx.scene.layout.HBox;

import java.util.List;

public interface ScrollList {
    public List<HBox> getList() throws MyException;
}
