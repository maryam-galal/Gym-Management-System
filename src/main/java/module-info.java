module com.example.mainpage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mainpage to javafx.fxml;
    exports com.example.mainpage;
}