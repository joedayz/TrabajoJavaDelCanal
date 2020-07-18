package pe.joedayz.models;

import java.util.Scanner;

public class Cliente {

	String nombre;
	String dni;
	String celular;

	public void registrarDatos() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresa el Nombre del Cliente: ");
		this.setNombre(scan.nextLine());
		System.out.print("DNI: ");
		this.setDni(scan.nextLine());
		System.out.print("Celular: ");
		this.setCelular(scan.nextLine());
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

	@Override
	public String toString() {
		return "Nombre: " + nombre + " " + "Dni: " + dni;
	}
}
