module com.fsb.linkedinProject {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens com.fsb.linkedinProject.Controllers to javafx.fxml;
    opens com.fsb.linkedinProject to javafx.fxml;
    exports com.fsb.linkedinProject;
    exports com.fsb.linkedinProject.Controllers;
}
