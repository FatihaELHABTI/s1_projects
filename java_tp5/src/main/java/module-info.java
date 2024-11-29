module com.example.java_tp5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires lombok;  // Ajoutez cette ligne pour déclarer que vous utilisez Lombok
    requires java.sql; // Dépendance pour MySQL JDBC

    opens com.example.java_tp5 to javafx.fxml;
    exports com.example.java_tp5;
}

