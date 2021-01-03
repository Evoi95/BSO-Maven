module com.example.BSOMaven {
    requires java.logging;
	requires java.sql;
	requires java.sql.rowset;
	requires java.desktop;
	requires itextpdf;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires org.junit.jupiter.api;
	exports application;
	opens application to javafx.graphics,javafx.base,javafx.controls,javafx.fxml;
	exports factoryBook;
	opens factoryBook to javafx.graphics,javafx.base,javafx.controls,javafx.fxml;
	exports pagamento;
	opens pagamento to javafx.graphics,javafx.base,javafx.controls,javafx.fxml;
	exports database;
	opens database to javafx.graphics,javafx.base,javafx.controls,javafx.fxml,java.sql;
	
	//exports reports;
	
<<<<<<< HEAD
	exports loginSingleton to javafx.graphics,javafx.base,javafx.controls,javafx.fxml;
	opens factoryUser;
	exports factoryUser to javafx.graphics,javafx.base,javafx.controls,javafx.fxml;
	
}
=======

}

>>>>>>> branch 'main' of https://github.com/Evoi95/BSO-Maven
