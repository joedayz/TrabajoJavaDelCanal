package pe.joedayz.supermercado.repository;

import java.util.List;

import pe.joedayz.supermercado.models.TipoProducto;

public interface TipoProductoRepository {

	void save(TipoProducto tipoProducto);

	void remove(TipoProducto tipoProducto);

	List<TipoProducto> findAll();

	TipoProducto findById(Integer id);

	void init();
}
