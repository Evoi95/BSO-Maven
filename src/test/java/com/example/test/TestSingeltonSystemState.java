package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllerApp.SingeltonSystemState;

class TestSingeltonSystemState {

	@Test
	public void testGetIstance() {
		assertNotNull(SingeltonSystemState.getIstance());
	}

	@Test
	public void testGetId() {
		SingeltonSystemState.getIstance().setId(2);
		assertNotEquals(0,SingeltonSystemState.getIstance().getId());
	}

	@Test
	public void testSetId() {
		 SingeltonSystemState.getIstance().setId(3);
		assertNotEquals(0,SingeltonSystemState.getIstance().getId());


	}

	@Test
	public void testSetTypeAsBook() {
		SingeltonSystemState.getIstance().setTypeAsBook();
		assertEquals("libro",SingeltonSystemState.getIstance().getType());

	}

	@Test
	public void testSetTypeAsMagazine() {
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		assertEquals("rivista",SingeltonSystemState.getIstance().getType());
	}

	@Test
	public void testSetTypeAsDaily() {
		SingeltonSystemState.getIstance().setTypeAsDaily();
		assertEquals("giornale",SingeltonSystemState.getIstance().getType());
	}

	@Test
	public void testGetType() {
		SingeltonSystemState.getIstance().setTypeAsBook();
		assertEquals("libro",SingeltonSystemState.getIstance().getType());
	}
	@Test
	public void testGetType1() {
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		assertEquals("rivista",SingeltonSystemState.getIstance().getType());
	}
	@Test
	public void testGetType2() {
		SingeltonSystemState.getIstance().setTypeAsDaily();
		assertEquals("giornale",SingeltonSystemState.getIstance().getType());
	}

	@Test
	public void testGetIsLogged() {
		
			SingeltonSystemState.getIstance().setIsLogged(false);
			assertEquals(false,SingeltonSystemState.getIstance().getIsLogged());
		
	}
	@Test
	public void testGetIsLogged1() {
		
			SingeltonSystemState.getIstance().setIsLogged(true);
			assertEquals(true,SingeltonSystemState.getIstance().getIsLogged());
		
	}

	@Test
	public void testSetIsLogged() {
		SingeltonSystemState.getIstance().setIsLogged(true);
		assertEquals(true,SingeltonSystemState.getIstance().getIsLogged());
	
	}

	@Test
	public void testGetIsSearch() {
		SingeltonSystemState.getIstance().setIsSearch(true);
		assertEquals(true,SingeltonSystemState.getIstance().getIsSearch());

		
	}

	@Test
	public void testSetIsSearch() {
		SingeltonSystemState.getIstance().setIsSearch(true);
	}

	@Test
	public void testGetIsPickup() {
		SingeltonSystemState.getIstance().setPickup(true);
		assertEquals(true,SingeltonSystemState.getIstance().getIsPickup());

		

	}

	@Test
	public void testSetPickup() {
		SingeltonSystemState.getIstance().setPickup(false);
	}

}
