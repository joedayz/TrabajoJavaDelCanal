package pe.joedayz.supermercado.models;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	List<Cliente> clientes = new ArrayList<>();
	List<Vendedor> vendedores = new ArrayList<>();

	public void mostrarClientes() {
		if(clientes.isEmpty()){
			System.out.println("No hay clientes registrados");
		}else{
			for(Cliente cliente: clientes){
				cliente.mostrarDatos();
			}
		}
	}

	public void agregarcliente(Cliente cliente) {

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

	public void mostrarVendedores() {
		if(vendedores.isEmpty()){
			System.out.println("No hay vendedores registrados");
		}else{
			for(Vendedor vendedor: vendedores){
				vendedor.mostrarDatos();
			}
		}
	}

	public void agregarVendedor(Vendedor vendedor) {
		this.getVendedores().add(vendedor);
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public boolean borrarVendedor(String dni) {
		boolean rpta = false;
		for(Vendedor v : this.getVendedores()){
			if(v.dni.equals(dni)){
				this.getVendedores().remove(v);
				rpta = true;
				break;
			}
		}
		return rpta;
	}

	public void mostrarProductos() {
	}
}
