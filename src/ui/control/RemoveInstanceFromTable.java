package ui.control;

import javafx.scene.control.TableView;
import ui.TableData;

public class RemoveInstanceFromTable implements Command {
    private final TableView<TableData> table;

    public RemoveInstanceFromTable(TableView<TableData> table) {
        this.table = table;
    }

    @Override
    public void execute() {
        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
    }
}
