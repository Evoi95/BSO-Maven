package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerReportRiviste;

class TestControllerReportRiviste {
	private ControllerReportRiviste cRR= new ControllerReportRiviste();

	@Test
	void testGeneraReportRiviste() {
		try {
			cRR.generaReportRiviste();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
