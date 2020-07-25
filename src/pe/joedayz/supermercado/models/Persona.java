package pe.joedayz.supermercado.models;

public abstract class Persona {

	String nombre;
	String dni;
	String celular;

	public abstract void registrarDatos();

	public void mostrarDatos(){
		System.out.print("Nombre: " + this.getNombre() + "\n"
				+ "DNI: " + this.getDni() + "\n"
				+ "Celular: " + this.getCelular() + "\n");
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getCelular() {
		return celular;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
