package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import factoryBook.CategorieLibro;

class TestCategorieLibro {
	private CategorieLibro cL;
	@Test
	 void testGetCategoria() {
		cL=new CategorieLibro("AdolescentiEragazzi");
		assertEquals("AdolescentiEragazzi",cL.getCategoria());
	}
	@Test
	 void testGetCategoria1() {
		cL=new CategorieLibro("RomanziRosa");
		assertEquals("RomanziRosa",cL.getCategoria());
	}
	@Test
	 void testGetCategoria2() {
		cL=new CategorieLibro("WebEDigitalMedia");
		assertEquals("WebEDigitalMedia",cL.getCategoria());
	}
	@Test
	 void testGetCategoria3() {
		cL=new CategorieLibro("Economia");
		assertEquals("Economia",cL.getCategoria());
	}


}
