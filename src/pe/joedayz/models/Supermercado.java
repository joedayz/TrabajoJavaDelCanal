package pe.joedayz.models;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	List<Cliente> clientes = new ArrayList<>();

	public void mostrarClientes() {
		if(clientes.isEmpty()){
			System.out.println("No hay clientes registrados");
		}else{
			for(Cliente cliente: clientes){
				System.out.println(cliente);
			}
		}
	}

	public void agregarcliente(Cliente cliente) {
		//TODO: No permitir ingresar un nuevo cliente con un DNI existente
		this.getClientes().add(cliente);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public boolean borrarCliente(String dni) {
		boolean rpta = false;
		for(Cliente c : this.getClientes()){
			if(c.dni.equals(dni)){
				this.getClientes().remove(c);
				rpta = true;
				break;
			}
		}
		return rpta;
	}
}
