package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerBsoRegister;

class TestControllerBSORegister {
	ControllerBsoRegister cBR=new ControllerBsoRegister();
	LocalDate date = LocalDate.of(1995, 10, 31);
	
	boolean state=false;



	@Test
	public void testRegistra() {
		try {
			assertEquals(state,cBR.registra("aaa", "bbb", "aaa.bbb@gmail.com", "aaabb10", "aaabb10",date));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCheckData() {
		assertNotEquals(state,cBR.checkData("Admin", "admin","Admin@admin.com", "admin871","admin871"));
	}

	@Test
	public void testCheckEmail() {
		assertNotEquals(state,cBR.checkEmail("zerocalcare@gmail.com"));
	}

	@Test
	public void testCheckPassword() {
		assertNotEquals(state,cBR.checkPassword("Zerocalcare21","Zerocalcare21"));
}

	@Test
	public void testCheckNomeCognome() {
		assertNotEquals(state,cBR.checkNomeCognome("pippo","pluto"));
	}

}
