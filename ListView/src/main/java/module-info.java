module com.yuanyuanis.concurrente.javafx.listview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.yuanyuanis.concurrente.javafx.listview to javafx.fxml;
    exports com.yuanyuanis.concurrente.javafx.listview;
}