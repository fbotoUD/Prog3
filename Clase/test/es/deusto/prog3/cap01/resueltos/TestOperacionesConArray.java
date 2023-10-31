package es.deusto.prog3.cap01.resueltos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.prog3.cap01.ejercicios.OperacionesConArray;

/*
 * 	1- Comprobar que sumarAPosicion() funciona como esperamos mediante un assertEquals().
	2- Crear otro método de testeo para ver que el método sumarAPosicion() salta la excepción IndexOutOfBoundsException,
	mediante la etiqueta @Test(expected = IndexOutOfBoundsException.class).
	2.1- Puedes implementar la estrategia try/catch
	3- Realizar un método de test que compruebe que sumarPosiciones() funciona correctamente con una prueba unitaria.
	4- Añadir otro método de testeo para comprobar que sumarPosiciones() lanza la excepción NullPointerException mediante un try catch y fail().
 */

public class TestOperacionesConArray {
	
	
	int arrayTest[] = {25,6,8,35,0,-1,-16};

	@Test
	public void Ejercicio1() {
		OperacionesConArray.sumarAPosicion(arrayTest, 1, 1);
		assertEquals(7,arrayTest[1]);
		
		OperacionesConArray.sumarAPosicion(arrayTest, 6,1);
		assertEquals(-15,arrayTest[6]);
	}
	
	//No me funciona
	@Test
	public void Ejercicio1Bucle() {
		int ultimaSuma = 15;
		for(int s = 0; s<=ultimaSuma;s++) {
			int arrayTestOp[] = {25,6,8,35,0,-1,-16};
			int arrayTestExp[] = {25,6,8,35,0,-1,-16};
			for (int i = 0; i<arrayTestExp.length;i++) {
				OperacionesConArray.sumarAPosicion(arrayTestExp, i, s);
			}
			
			for (int i = 0; i<arrayTest.length;i++) {
				OperacionesConArray.sumarAPosicion(arrayTestOp, i, s);
				assertEquals(arrayTestExp[i], arrayTestOp[i]);
			}
		}
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void ejercicio2() {
		OperacionesConArray.sumarAPosicion(arrayTest, 21,1);
	}
	
	@Test
	public void ejercicio21() {
		try {
			OperacionesConArray.sumarAPosicion(arrayTest, 21,1);
			fail();
		}
		catch (IndexOutOfBoundsException e) {
		}
	}
	
	@Test
	public void ejercicio3() {
		int res = OperacionesConArray.sumarPosiciones(arrayTest);
		assertEquals(res,57);
		
	}
	
	@Test
	public void ejercicio4() {
		try {
			OperacionesConArray.sumarPosiciones(null);
			fail();
		} catch (Exception e) {
		}
			
	}
	

}
