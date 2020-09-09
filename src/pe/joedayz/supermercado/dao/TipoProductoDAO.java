package pe.joedayz.supermercado.dao;

import java.util.List;

import pe.joedayz.supermercado.models.TipoProducto;

public interface TipoProductoDAO {

	void save(TipoProducto tipoProducto);

	void remove(TipoProducto tipoProducto);

	List<TipoProducto> all();

	TipoProducto findById(Integer id);

	void init();
}
