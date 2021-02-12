package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerReportLibri;

class TestControllerReportLibri {
	private ControllerReportLibri cRL=new ControllerReportLibri();
	

	@Test
	void testGeneraReportLibri() {
		try {
			cRL.generaReportLibri();
		} catch (IOException | SQLException e) {
		 
			
		}
	}

}
