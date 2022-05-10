package ui;

import javafx.beans.property.SimpleStringProperty;

public class TableData {
    private final SimpleStringProperty barcodeId, barCodeNote;

    public TableData(String barcodeId, String barCodeNote) {
        this.barcodeId = new SimpleStringProperty(barcodeId);
        this.barCodeNote = new SimpleStringProperty(barCodeNote);
    }

    public String getBarcodeId() {
        return barcodeId.get();
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId.set(barcodeId);
    }

    public String getBarCodeNote() {
        return barCodeNote.get();
    }

    public void setBarCodeNote(String barCodeNote) {
        this.barCodeNote.set(barCodeNote);
    }
}
