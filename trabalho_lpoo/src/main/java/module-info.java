module com.lpoo.project {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lpoo.project.view to javafx.fxml;
    opens com.lpoo.project.controller to javafx.fxml;
    exports com.lpoo.project.view;
}
