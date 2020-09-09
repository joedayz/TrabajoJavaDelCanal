package pe.joedayz.supermercado.service;

import java.util.List;

import pe.joedayz.supermercado.models.TipoProducto;
import pe.joedayz.supermercado.repository.TipoProductoRepository;
import pe.joedayz.supermercado.repository.TipoProductoRepositoryImpl;

public class TipoProductoServiceImpl implements TipoProductoService{

	private final TipoProductoRepository tipoProductoRepository = new TipoProductoRepositoryImpl();

	@Override
	public List<TipoProducto> getTiposProductos() {
		return tipoProductoRepository.findAll();
	}

	@Override
	public void agregarTipoProducto(TipoProducto tipoProducto) {
		tipoProductoRepository.save(tipoProducto);
	}

	@Override
	public TipoProducto findById(Integer id) {
		return tipoProductoRepository.findById(id);
	}

	@Override
	public void removerTipoProducto(TipoProducto tipoProducto) {
		tipoProductoRepository.remove(tipoProducto);
	}
}
