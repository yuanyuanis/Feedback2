module com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires retrofit2;
    requires converter.gson;
    requires java.sql;

    opens com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail to javafx.fxml;
    opens com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail.domain;
    exports com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail;
}