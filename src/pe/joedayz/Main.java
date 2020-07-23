package pe.joedayz;

import java.util.Scanner;

import pe.joedayz.models.Cliente;
import pe.joedayz.models.Persona;
import pe.joedayz.models.Supermercado;
import pe.joedayz.models.Vendedor;

public class Main {

    public static void main(String[] args) {
		Supermercado supermercado = new Supermercado();
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("Seleccione una opción: \n"
					+ "1.- Gestión de Clientes\n"
					+ "2.- Gestión de Vendedores\n"
					+ "3.- Gestión de Productos\n"
					+ "4.- Ventas\n"
					+ "5.- Salir\n");
			int opcion = scan.nextInt();
			scan.nextLine();
			switch (opcion){
				case 1:
					gestionClientes(supermercado, scan);
					break;
				case 2:
					gestionVendedores(supermercado, scan);
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					System.exit(0);
					break;
			}
		}
    }

	private static void gestionVendedores(Supermercado supermercado, Scanner scan) {
		int opcion;
		while (true) {
			boolean retornar = false;
			System.out.println("Seleccione una opción: \n"
					+ "1.- Mostrar Vendedores\n"
					+ "2.- Agregar Vendedor\n"
					+ "3.- Borrar Vendedor\n"
					+ "4.- Borrar todos los Vendedores\n"
					+ "5.- Regresar\n");
			opcion = scan.nextInt();
			scan.nextLine();
			switch (opcion) {
				case 1:
					supermercado.mostrarVendedores();
					break;
				case 2:
					Vendedor vendedor = new Vendedor();
					vendedor.registrarDatos();
					supermercado.agregarVendedor(vendedor);
					break;
				case 3:
					System.out.println("Ingresa el DNI del Vendedor:");
					String dni = scan.nextLine();
					if(supermercado.borrarVendedor(dni)){
						System.out.println("Vendedor eliminado satisfactoriamente.");
					}else{
						System.out.println("Vendedor no encontrado.");
					}
					break;
				case 4:
					supermercado.getVendedores().clear();
					break;
				case 5:
					retornar = true;
					break;
			}
			if (retornar) {
				break;
			}
		}
	}

	private static void gestionClientes(Supermercado supermercado, Scanner scan) {
		int opcion;
		while(true){
			boolean retornarAMenu = false;
			System.out.println("Seleccione una opción: \n"
					+ "1.- Mostrar Clientes\n"
					+ "2.- Agregar Cliente\n"
					+ "3.- Borrar Cliente\n"
					+ "4.- Borrar Todos clientes\n"
					+ "5.- Regresar\n");
			opcion = scan.nextInt();
			scan.nextLine();
			switch (opcion) {
				case 1:
					supermercado.mostrarClientes();
					break;
				case 2:
					Cliente cliente = new Cliente();
					cliente.registrarDatos();
					supermercado.agregarcliente(cliente);
					break;
				case 3:
					System.out.println("Ingresa el DNI del cliente:");
					String dni = scan.nextLine();
					if(supermercado.borrarCliente(dni)){
						System.out.println("Cliente eliminado satisfactoriamente.");
					}else{
						System.out.println("Cliente no encontrado.");
					}
					break;
				case 4:
					supermercado.getClientes().clear();
					break;
				case 5:
					retornarAMenu = true;
					break;

			}
			if(retornarAMenu){
				break;
			}

		}
	}
}
