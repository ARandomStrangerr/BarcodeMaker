package ui;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.control.AddInstanceFromExcel;
import ui.control.AddOneInstanceToTable;
import ui.control.RemoveInstanceFromTable;

public class MainDisplay {
    private final Stage ownerStage;
    public final VBox pane;

    public MainDisplay(Stage ownerStage) {
        this.ownerStage = ownerStage;
        pane = new VBox();
        setupDisplay();
    }

    private void setupDisplay() {
        Label printerDpiLabel,
                stampWidthLabel,
                stampHeightLabel,
                measureUnitLabel,
                displayBarcodeNumberLabel,
                displayBarcodeNoteLabel;
        printerDpiLabel = new Label("Dots per Inch (dpi)");
        stampWidthLabel = new Label("Độ rộng tem");
        stampHeightLabel = new Label("Độ tao tem");
        measureUnitLabel = new Label("Đơn vị");
        displayBarcodeNumberLabel = new Label("Hiển thị số trên tem");
        displayBarcodeNoteLabel = new Label("Hiển thị trú thích trên tem");

        CheckBox displayBarcodeNumberCheckBox,
                displayBarcodeNodeCheckBox;
        displayBarcodeNumberCheckBox = new CheckBox();
        displayBarcodeNodeCheckBox = new CheckBox();

        TextField printerDpiInput,
                stampWidthInput,
                stampHeightInput;
        printerDpiInput = new TextField();
        stampWidthInput = new TextField();
        stampHeightInput = new TextField();

        ChoiceBox<String> measureUnitChoice;
        measureUnitChoice = new ChoiceBox<>();
        measureUnitChoice.setItems(FXCollections.observableArrayList("Millimeter",
                "Centimeter",
                "Decimeter"));

        TableColumn<TableData, String> barcodeIdCol,
                barcodeNoteCol;
        barcodeIdCol = new TableColumn<>("Mã");
        barcodeIdCol.setCellValueFactory(new PropertyValueFactory<>("barcodeId"));
        barcodeNoteCol = new TableColumn<>("Chú thích");
        barcodeNoteCol.setCellValueFactory(new PropertyValueFactory<>("barCodeNote"));

        TableView<TableData> table = new TableView<>();
        table.getColumns().addAll(barcodeIdCol,
                barcodeNoteCol);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button removeInstanceButton;
        removeInstanceButton = new Button("-");
        removeInstanceButton.setOnAction((event) -> new RemoveInstanceFromTable(table).execute());

        MenuItem addOneInstance,
                addFromExcel;
        addOneInstance = new MenuItem("Thêm một");
        addOneInstance.setOnAction((event) -> new AddOneInstanceToTable(table.getItems()).execute());
        addFromExcel = new MenuItem("Thêm từ Excel");
        addFromExcel.setOnAction((event) -> new AddInstanceFromExcel(table.getItems()).execute());

        MenuButton addInstanceButton;
        addInstanceButton = new MenuButton("+");
        addInstanceButton.getItems().addAll(addOneInstance,
                addFromExcel);

        HBox printerDpiWrapper,
                stampSizeWrapper,
                displayChoiceWrapper,
                tableButtonWrapper;
        printerDpiWrapper = new HBox(printerDpiLabel,
                printerDpiInput);
        stampSizeWrapper = new HBox(stampWidthLabel,
                stampWidthInput,
                stampHeightLabel,
                stampHeightInput,
                measureUnitLabel,
                measureUnitChoice);
        displayChoiceWrapper = new HBox(displayBarcodeNumberLabel,
                displayBarcodeNumberCheckBox,
                displayBarcodeNoteLabel,
                displayBarcodeNodeCheckBox);
        tableButtonWrapper = new HBox(addInstanceButton,
                removeInstanceButton);

        pane.getChildren().addAll(tableButtonWrapper,
                table,
                printerDpiWrapper,
                stampSizeWrapper,
                displayChoiceWrapper);
        pane.setStyle("-fx-font-family: serif");
    }
}
