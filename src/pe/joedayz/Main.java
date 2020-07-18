package pe.joedayz;

import java.util.Scanner;

import pe.joedayz.models.Cliente;
import pe.joedayz.models.Supermercado;

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
					break;
				case 2:
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
}
