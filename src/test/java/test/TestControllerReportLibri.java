package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerReportLibri;

class TestControllerReportLibri {
	private ControllerReportLibri cRL=new ControllerReportLibri();
	

	@Test
	public void testGeneraReportLibri() {
		try {
			cRL.generaReportLibri();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
