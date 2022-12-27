module com.example.ecommerce_d {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.ecommerce_d to javafx.fxml;
    exports com.example.ecommerce_d;
}