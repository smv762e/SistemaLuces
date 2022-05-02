
public class Triestable implements IEstado {
	
	private boolean[] lights;
	private static final int numLights = 3;
	private String estado;
	
	public Triestable() {
		lights = new boolean[numLights];
		lights[0] = true;
	}
	
	public void setSite(int light, boolean site) {
		lights[light] = site;
		int cont = 0;
		for (int i = 0; i < numLights; i++) {
			if (lights[i] == true) {
				cont = cont + 1;
			}
		}
		if (cont > 1) {
			throw new RuntimeException("Error: Más de una luz encendida");
		}
	}
	
	public String getEstado() {
		for (int i = 0; i < numLights; i++) {
			if (i == 0 && lights[0] == true) {
				estado = "cerrado";
			}
			if (i == 1 && lights[1] == true) {
				estado = "precaución";
			}
			if (i == 2 && lights[2] == true) {
				estado = "abierto";
			}
		}
		return estado;
	}

	public void abrir() {
		for (int i = 2; i >= 0; i--) {
			if (lights[i] == true && i != 2) {
				lights[i] = false;
				lights[i + 1] = true;
			}
			if (lights[i] == true && i == 2) {
				System.out.println("Máxima acción alcanzada");
			}
		}
	}

	public void cerrar() {
		for (int i = 0; i < numLights; i++) {
			if (lights[i] == true && i != 0) {
				lights[i] = false;
				lights[i - 1] = true;
			}
			if (lights[i] == true && i == 0) {
				System.out.println("Máxima acción alcanzada");
			}
		}
	}

}

