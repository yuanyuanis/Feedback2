module com.yuanyuanis.concurrente.restcountriesv3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires retrofit2;
    requires converter.gson;
    requires java.sql;

    opens com.yuanyuanis.concurrente.restcountriesv3 to javafx.fxml;
    opens com.yuanyuanis.concurrente.restcountriesv3.controller to javafx.fxml;
    opens com.yuanyuanis.concurrente.restcountriesv3.domain;
    exports com.yuanyuanis.concurrente.restcountriesv3;
    exports com.yuanyuanis.concurrente.restcountriesv3.controller;
}