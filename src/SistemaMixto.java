
public class SistemaMixto implements IEstado {
	
	private boolean[] lights;
	private int numLights;
	private String estado;
	
	public SistemaMixto() {
	}
	
	public int getNumLights() {
		return this.numLights;
	}
	
	public void setSystem(int num) {
		numLights = num;
		if (numLights < 2 || numLights > 3) {
			throw new RuntimeException("Error: Número de luces erroneo");
		}
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
		if (light > numLights) {
			throw new RuntimeException("Error: Luz fuera de los límites");
		}
	}
	
	public String getEstado() {
		for (int i = 0; i < 3; i++) {
			if (i == 0 && lights[0] == true) {
				estado = "cerrado";
			}
			if (i == 1 && lights[1] == true && numLights == 3) {
				estado = "precaución";
			}
			if (i == numLights - 1 && lights[numLights - 1] == true) {
				estado = "abierto";
			}
		}
		return estado;
	}

	public void abrir() {
		for (int i = numLights - 1; i >= 0; i--) {
			if (lights[i] == true && i != numLights - 1) {
				lights[i] = false;
				lights[i + 1] = true;
			}
			if (lights[i] == true && i == numLights - 1) {
				System.out.println("Máxima acción alcanzada");
			}
		}
	}

	public void cerrar() {
		for (int i = 0; i < lights.length; i++) {
			if (lights[i] == true && i != 0) {
				lights[i] = false;
				lights[i - 1] = true;
			}
			if (lights[i] == true && i == 0) {
				System.out.println("Máxima acción alcanzada");
			}
		}
	}
	
	public void cambio() {
		int currentSystem = getNumLights();
		String status = getEstado();
		if (currentSystem == 2) {
			if (status == "cerrado") {
				setSystem(3);
			}
			if (status == "abierto") {
				setSystem(3);
				abrir();
				abrir();
			}
			
		}
		if (currentSystem == 3) {
			if (status == "cerrado") {
				setSystem(2);
			}
			if (status == "precaución") {
				setSystem(2);
			}
			if (status == "abierto") {
				setSystem(2);
				abrir();
			}
		}
	}
	
}

