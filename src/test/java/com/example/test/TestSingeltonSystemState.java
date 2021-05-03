package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.SingeltonSystemState;

class TestSingeltonSystemState {

	@Test
	void testGetIstance() {
		assertNotNull(SingeltonSystemState.getIstance());
	}

	@Test
	void testGetId() {
		SingeltonSystemState.getIstance().setId(2);
		assertNotEquals(0,SingeltonSystemState.getIstance().getId());
	}

	@Test
	void testSetId() {
		 SingeltonSystemState.getIstance().setId(3);
		assertNotEquals(0,SingeltonSystemState.getIstance().getId());


	}

	@Test
	void testSetTypeAsBook() {
		SingeltonSystemState.getIstance().setTypeAsBook();
		assertEquals("libro",SingeltonSystemState.getIstance().getType());

	}

	@Test
	void testSetTypeAsMagazine() {
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		assertEquals("rivista",SingeltonSystemState.getIstance().getType());
	}

	@Test
	void testSetTypeAsDaily() {
		SingeltonSystemState.getIstance().setTypeAsDaily();
		assertEquals("giornale",SingeltonSystemState.getIstance().getType());
	}

	@Test
	void testGetType() {
		SingeltonSystemState.getIstance().setTypeAsBook();
		assertEquals("libro",SingeltonSystemState.getIstance().getType());
	}
	@Test
	void testGetType1() {
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		assertEquals("rivista",SingeltonSystemState.getIstance().getType());
	}
	@Test
	void testGetType2() {
		SingeltonSystemState.getIstance().setTypeAsDaily();
		assertEquals("giornale",SingeltonSystemState.getIstance().getType());
	}

	@Test
	void testGetIsLogged() {
		
			SingeltonSystemState.getIstance().setIsLogged(false);
			assertEquals(false,SingeltonSystemState.getIstance().getIsLogged());
		
	}
	@Test
	void testGetIsLogged1() {
		
			SingeltonSystemState.getIstance().setIsLogged(true);
			assertEquals(true,SingeltonSystemState.getIstance().getIsLogged());
		
	}

	@Test
	void testSetIsLogged() {
		SingeltonSystemState.getIstance().setIsLogged(true);
		assertEquals(true,SingeltonSystemState.getIstance().getIsLogged());
	
	}

	@Test
	void testGetIsSearch() {
		SingeltonSystemState.getIstance().setIsSearch(true);
		assertEquals(true,SingeltonSystemState.getIstance().getIsSearch());

		
	}

	@Test
	void testSetIsSearch() {
		SingeltonSystemState.getIstance().setIsSearch(true);
	}

	@Test
	void testGetIsPickup() {
		SingeltonSystemState.getIstance().setPickup(true);
		assertEquals(true,SingeltonSystemState.getIstance().getIsPickup());

		

	}

	@Test
	void testSetPickup() {
		SingeltonSystemState.getIstance().setPickup(false);
	}

}
