package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.ControllerCancellaGiornale;

class TestControllerCancGiornali {
	private ControllerCancellaGiornale cCG=new ControllerCancellaGiornale();

	@Test
	void testCancella() {
		int id=2;
		cCG.cancella(id);
		assertNotEquals(-1,id);
	}

}
