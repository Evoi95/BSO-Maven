package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import database.CreateDefaultDB;

class TestCreateDefaultDB {

	@Test
	public void testCreateDefaultDB() throws ClassNotFoundException, FileNotFoundException, SQLException {
		CreateDefaultDB.createDefaultDB();
	}
	/*

	@Test
	public void testCreateTrigger() throws SQLException {
		CreateDefaultDB.createTrigger();
	}
*/
}
