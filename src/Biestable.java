
public class Biestable implements IEstado {
	
	private boolean[] lights;
	private static final int numLights = 2;
	private String estado;
	
	public Biestable() {
		lights = new boolean[numLights];
		lights[0] = true;
	}
	
	public void setSite(int light, boolean site) {
		lights[light] = site;
		if (lights[0] == true && lights[1] == true) {
			throw new RuntimeException("Error: Más de una luz encendida");
		}
	}
	
	public String getEstado() {
		if (lights[0] == true) {
			estado = "cerrado";
		}
		if (lights[1] == true) {
			estado = "abierto";
		}
		return estado;
	}

	public void abrir() {
		if (lights[0] == true) {
			lights[0] = false;
			lights[1] = true; 
		} 
		if (lights[1] == true) {
			
		}
	}

	public void cerrar() {
		if (lights[1] == true) {
			lights[1] = false;
			lights[0] = true; 
		} 
		if (lights[0] == true) {
			
		}
	}

}
