import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestBiestable {

	private final Biestable bt = new Biestable();
	
	@Test
	public void abrirNormal() {
		bt.abrir();
		assertEquals("abierto", bt.getEstado());
	}
	
	@Test
	public void cerrarNormal() {
		bt.setSite(0, false);
		bt.setSite(1, true);
		bt.cerrar();
		assertEquals("cerrado", bt.getEstado());
	}
	
	@Test
	public void general() {
		assertEquals("cerrado", bt.getEstado());
		bt.abrir();
		assertEquals("abierto", bt.getEstado());
		bt.cerrar();
		assertEquals("cerrado", bt.getEstado());
		assertThrows(Exception.class, ()->bt.setSite(1, true));
	}
	
}
