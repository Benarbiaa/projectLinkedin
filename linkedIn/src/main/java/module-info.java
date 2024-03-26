module project.linkedIn {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens project.linkedIn.controllers to javafx.fxml;
    exports project.linkedIn;
}
