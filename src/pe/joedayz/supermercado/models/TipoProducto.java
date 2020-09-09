package pe.joedayz.supermercado.models;

import java.util.Objects;

public class TipoProducto {

	private Integer id;
	private String nombre;

	public TipoProducto() {
	}

	public TipoProducto(String nombre) {
		this.nombre = nombre;
	}

	public TipoProducto(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TipoProducto other = (TipoProducto) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

}
