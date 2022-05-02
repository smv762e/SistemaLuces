import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestTriestable {

	private final Triestable tt = new Triestable();
	
	@Test
	public void abrirNormal() {
		tt.abrir();
		assertEquals("precaución", tt.getEstado());
		tt.abrir();
		assertEquals("abierto", tt.getEstado());
	}
	
	@Test
	public void cerrarNormal() {
		tt.setSite(0, false);
		tt.setSite(2, true);
		tt.cerrar();
		assertEquals("precaución", tt.getEstado());
		tt.cerrar();
		assertEquals("cerrado", tt.getEstado());
	}
	
	@Test
	public void abrirWarning() {
		tt.abrir();
		assertEquals("precaución", tt.getEstado());
	}
	
	@Test
	public void cerrarWarning() {
		tt.setSite(0, false);
		tt.setSite(2, true);
		tt.cerrar();
		assertEquals("precaución", tt.getEstado());
	}
	
	@Test
	public void testCompleto() {
		assertEquals("cerrado", tt.getEstado());
		tt.abrir();
		assertEquals("precaución", tt.getEstado());
		tt.abrir();
		assertEquals("abierto", tt.getEstado());
		tt.cerrar();
		assertEquals("precaución", tt.getEstado());
		tt.cerrar();
		assertEquals("cerrado", tt.getEstado());
	}
	
	@Test
	public void general() {
		assertEquals("cerrado", tt.getEstado());
		tt.abrir();
		assertEquals("precaución", tt.getEstado());
		tt.cerrar();
		assertEquals("cerrado", tt.getEstado());
		assertThrows(Exception.class, ()->tt.setSite(1, true));
	}
	
}
