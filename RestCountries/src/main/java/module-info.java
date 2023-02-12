module com.yuanyuanis.concurrente.restcountries {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.yuanyuanis.concurrente.restcountries to javafx.fxml;
    opens com.yuanyuanis.concurrente.restcountries.domain;
    exports com.yuanyuanis.concurrente.restcountries;
}