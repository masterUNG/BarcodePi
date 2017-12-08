package androidthai.in.th.barcodepi.utility;

/**
 * Created by masterung on 5/12/2017 AD.
 */

public class MyConstant {

    private String[] connectedStrings = new String[]{"On", "Off"};

    private String[] columnProductStrings = new String[]{
            "id",
            "NameProduct",
            "Barcode",
            "Price",
            "Detail",
            "PathImage",
            "Item"};

    public String[] getConnectedStrings() {
        return connectedStrings;
    }

    public String[] getColumnProductStrings() {
        return columnProductStrings;
    }
}   // Main Class
