module com.example.test {
    requires java.logging;
	requires java.sql;
	requires java.sql.rowset;
	requires java.desktop;
	requires itextpdf;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires mybatis;
	
	exports boundary.laptop;
	opens boundary.laptop to javafx.graphics,javafx.base,javafx.controls,javafx.fxml;
	exports factoryBook;
	opens factoryBook to javafx.graphics,javafx.base,javafx.controls,javafx.fxml;
	exports pagamento;
	opens pagamento to javafx.graphics,javafx.base,javafx.controls,javafx.fxml;
	exports database;
	opens database to javafx.graphics,javafx.base,javafx.controls,javafx.fxml,java.sql;


}
