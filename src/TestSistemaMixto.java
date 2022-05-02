import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TestSistemaMixto {

	private final SistemaMixto sm = new SistemaMixto();
	
	@Test
	public void abrirNormal() {
		sm.setSystem(3);
		sm.abrir();
		assertEquals("precaución", sm.getEstado());
		sm.abrir();
		assertEquals("abierto", sm.getEstado());
	}
	
	@Test
	public void cambio3a2 () {
		sm.setSystem(3);
		sm.abrir();
		assertEquals("precaución", sm.getEstado());
		sm.abrir();
		assertEquals("abierto", sm.getEstado());
		sm.cambio();
		assertEquals(2, sm.getNumLights());
		assertEquals("abierto", sm.getEstado());
	}
	
	@Test
	public void cambio2a3() {
		sm.setSystem(2);
		assertEquals(2, sm.getNumLights());
		sm.abrir();
		assertEquals("abierto", sm.getEstado());
		sm.abrir();
		assertThrows(Exception.class, ()-> sm.setSite(2, true));
		sm.cambio();
		assertEquals(3, sm.getNumLights());
	}
	
	@Test
	public void cambioMultiple () {
		sm.setSystem(3);
		sm.abrir();
		assertEquals("precaución", sm.getEstado());
		sm.abrir();
		assertEquals("abierto", sm.getEstado());
		sm.cambio();
		assertEquals(2, sm.getNumLights());
		assertEquals("abierto", sm.getEstado());
		sm.cambio();
		assertEquals(3, sm.getNumLights());
		assertEquals("abierto", sm.getEstado());
		sm.cerrar();
		assertEquals("precaución", sm.getEstado());
		sm.cambio();
		assertEquals(2, sm.getNumLights());
		assertEquals("cerrado", sm.getEstado());
	}
	
	@Test
	public void cerrarNormal() {
		sm.setSystem(3);
		sm.setSite(0, false);
		sm.setSite(2, true);
		sm.cerrar();
		assertEquals("precaución", sm.getEstado());
		sm.cerrar();
		assertEquals("cerrado", sm.getEstado());
	}
	
	@Test
	public void abrirWarning() {
		sm.setSystem(3);
		sm.abrir();
		assertEquals("precaución", sm.getEstado());
	}
	
	@Test
	public void cerrarWarning() {
		sm.setSystem(3);
		sm.setSite(0, false);
		sm.setSite(2, true);
		sm.cerrar();
		assertEquals("precaución", sm.getEstado());
	}
	
	@Test
	public void testCompleto() {
		sm.setSystem(3);
		assertEquals("cerrado", sm.getEstado());
		sm.abrir();
		assertEquals("precaución", sm.getEstado());
		sm.abrir();
		assertEquals("abierto", sm.getEstado());
		sm.cerrar();
		assertEquals("precaución", sm.getEstado());
		sm.cerrar();
		assertEquals("cerrado", sm.getEstado());
	}
	
	@Test
	public void numLuces() {
		sm.setSystem(3);
		assertEquals(3, sm.getNumLights());
		assertEquals("cerrado", sm.getEstado());
	}
	
	@Test
	public void testComplejo() {
		sm.setSystem(2);
		assertEquals("cerrado", sm.getEstado());
		sm.cambio();
		sm.abrir();
		assertEquals("precaución", sm.getEstado());
	}
	
}
