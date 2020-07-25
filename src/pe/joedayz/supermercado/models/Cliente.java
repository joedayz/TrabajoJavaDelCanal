package pe.joedayz.supermercado.models;

import java.util.Scanner;

public class Cliente extends Persona{

	private String tarjetaBonus;

	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Tarjeta Bonus: " +
				this.getTarjetaBonus() + "\n");
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
		System.out.print("Tarjeta Bonus: ");
		this.setTarjetaBonus(scan.nextLine());
	}

	public String getTarjetaBonus() {
		return tarjetaBonus;
	}

	public void setTarjetaBonus(String tarjetaBonus) {
		this.tarjetaBonus = tarjetaBonus;
	}
}
