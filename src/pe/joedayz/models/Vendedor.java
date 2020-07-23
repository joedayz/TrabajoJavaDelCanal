package pe.joedayz.models;

import java.util.Scanner;

public class Vendedor extends Persona{

	private String codVendedor;

	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Código de vendedor: " + this.getCodVendedor() + "\n");
	}

	@Override
	public void registrarDatos() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresa el Nombre del Cliente: ");
		this.setNombre(scan.nextLine());
		System.out.print("DNI: ");
		this.setDni(scan.nextLine());
		System.out.print("Celular: ");
		this.setCelular(scan.nextLine());
		System.out.print("Código de Vendedor: ");
		this.setCodVendedor(scan.nextLine());
	}

	public String getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(String codVendedor) {
		this.codVendedor = codVendedor;
	}
}
