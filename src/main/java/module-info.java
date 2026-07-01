module lk.ijse.sams {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens lk.ijse.sams.ViewController to javafx.fxml;
    opens lk.ijse.sams.Entity to javafx.base; 
    opens lk.ijse.sams.dto to javafx.base;
    exports lk.ijse.sams;
}
