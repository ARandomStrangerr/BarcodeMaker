package ui.control;

import javafx.collections.ObservableList;
import ui.TableData;

public class AddInstanceFromExcel implements Command{
    private final ObservableList<TableData> tableData;

    public AddInstanceFromExcel(ObservableList<TableData> tableData) {
        this.tableData = tableData;
    }

    @Override
    public void execute() {

    }
}
