package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import factoryBook.CategorieRivista;

class TestCategorieRivista {
	private CategorieRivista cR;

	@Test
	void testGetCategoria() {
		cR=new CategorieRivista("informatica");
		assertEquals("informatica",cR.getCategoria());
	}
	@Test
	void testGetCategoria1() {
		cR=new CategorieRivista("militare");
		assertEquals("militare",cR.getCategoria());
	}
	@Test
	void testGetCategoria2() {
		cR=new CategorieRivista("sportivo");
		assertEquals("sportivo",cR.getCategoria());
	}
	@Test
	void testGetCategoria3() {
		cR=new CategorieRivista("mensile");
		assertEquals("mensile",cR.getCategoria());
	}

}
