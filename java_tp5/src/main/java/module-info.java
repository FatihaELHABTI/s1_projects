module com.example.java_tp5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_tp5 to javafx.fxml;
    exports com.example.java_tp5;
}