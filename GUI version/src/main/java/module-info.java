module com.example.calculatorv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.calculatorv2 to javafx.fxml;
    exports com.example.calculatorv2;
}