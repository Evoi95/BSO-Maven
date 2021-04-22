package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import factoryBook.CategorieLibro;

class TestCategorieLibro {
	private CategorieLibro cL;
	@Test
	 public void testGetCategoria() {
		cL=new CategorieLibro("AdolescentiEragazzi");
		assertEquals("AdolescentiEragazzi",cL.getCategoria());
	}
	@Test
	 public void testGetCategoria1() {
		cL=new CategorieLibro("RomanziRosa");
		assertEquals("RomanziRosa",cL.getCategoria());
	}
	@Test
	 public void testGetCategoria2() {
		cL=new CategorieLibro("WebEDigitalMedia");
		assertEquals("WebEDigitalMedia",cL.getCategoria());
	}
	@Test
	 public void testGetCategoria3() {
		cL=new CategorieLibro("Economia");
		assertEquals("Economia",cL.getCategoria());
	}


}
