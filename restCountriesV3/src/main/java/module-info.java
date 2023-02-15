module com.yuanyuanis.concurrente.restcountriesv3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires retrofit2;
    requires converter.gson;
    requires io.reactivex.rxjava3;
    requires java.sql;
    requires adapter.rxjava;
    requires rxjava;

    opens com.yuanyuanis.concurrente.restcountriesv3 to javafx.fxml;
    opens com.yuanyuanis.concurrente.restcountriesv3.controller to javafx.fxml, io.reactivex.rxjava3;
    opens com.yuanyuanis.concurrente.restcountriesv3.domain;
    exports com.yuanyuanis.concurrente.restcountriesv3;
    exports com.yuanyuanis.concurrente.restcountriesv3.controller;
}