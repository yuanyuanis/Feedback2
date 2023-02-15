module com.yuanyuanis.openfoodfactsjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.yuanyuanis.openfoodfactsjavafx to javafx.fxml;
    exports com.yuanyuanis.openfoodfactsjavafx;
}