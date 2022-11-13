module com.lpoo.project {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lpoo.project to javafx.fxml;
    exports com.lpoo.project.view;
}
