package es.deusto.prog3.cap01.resueltos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 *	1- Crear un método de test de excepción a la clase Operacion (dividir entre cero) utilizando un único assertFalse() y try catch.
	2- Añadir otro método de test comprobando que 10/2=5 utilizando únicamente el método fail() de Junit.
	3- Realizar otro método de test para el mismo método comprobando que lanza excepción al dividir entre cero con assertTrue() y un try catch.
	4- Crear otro método de test para comprobar que 6/3=2 realmente es así utilizando assertTrue().
 */

public class TestOperacion {
	private int a;
	private int b;
	@Before
	public void setUp() throws Exception {
		a = 4;
		b = 2;
	}
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testDivisionAssert() {
		int res = Operacion.division(a,b);
		assertEquals(2, res, 0.0);
	}
	
	
	@Test
	public void testDivisionTryCatch() {
		b = 0;
		try {
			int res = Operacion.division(a,b);
			fail();
		} catch(ArithmeticException e) {
			/* Ha lanzado excepcion, por lo tanto, ha saltado al
			catch y no ha llegado a la linea fail(), y, por eso, el
			test es correcto */
		}
	}
	@Test (expected = ArithmeticException.class)
	public void testDivisionExpected() {
		b = 0;
		int res = Operacion.division(a,b);
	}
	
	
	@Test
	public void ejercicio1() {

		boolean noerror = false;
		try {
			Operacion.division(4, 0);
			noerror = true;
		} catch (Exception e) {
			assertFalse(noerror);
		}
	}
	
	@Test
	public void ejercicio2() {
		int res = Operacion.division(10,5);
		if(res != 2) fail();
	}
	
	
	@Test
	public void ejercicio3() {
		boolean error = true;
		try {
			Operacion.division(4, 0);
			error = false;
		} catch (Exception e) {
			assertTrue(error);
		}
	}
	
	@Test
	public void ejercicio4() {
		int res = Operacion.division(6,3);
		assertTrue(res == 2);
	}
}

