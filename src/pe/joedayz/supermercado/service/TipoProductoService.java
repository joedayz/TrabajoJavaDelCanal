package pe.joedayz.supermercado.service;

import java.util.List;

import pe.joedayz.supermercado.models.TipoProducto;

public interface TipoProductoService {
	public List<TipoProducto> getTiposProductos();
	public void agregarTipoProducto(TipoProducto tipoProducto);
	public TipoProducto findById(Integer id);
	public void removerTipoProducto(TipoProducto tipoProducto);
}
