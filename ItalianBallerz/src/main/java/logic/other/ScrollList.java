package logic.other;

import errorlogic.MyException;
import javafx.scene.layout.HBox;

import java.util.List;


/**
 * Interfaccia dell'oggetto creato dalla factory
 */
public interface ScrollList {
    List<HBox> getList() throws MyException;
}
