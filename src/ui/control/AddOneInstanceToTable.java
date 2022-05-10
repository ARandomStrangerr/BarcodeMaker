package ui.control;

import javafx.collections.ObservableList;
import ui.TableData;

public class AddOneInstanceToTable implements Command {
    private final ObservableList<TableData> tableData;

    public AddOneInstanceToTable(ObservableList<TableData> tableData) {
        this.tableData = tableData;
    }

    @Override
    public void execute() {
        tableData.add(new TableData("Trống", "Trống"));
    }
}
