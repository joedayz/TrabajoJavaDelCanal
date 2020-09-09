package pe.joedayz.supermercado.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import pe.joedayz.supermercado.Messages;
import pe.joedayz.supermercado.models.TipoProducto;
import pe.joedayz.supermercado.service.TipoProductoService;
import pe.joedayz.supermercado.service.TipoProductoServiceImpl;

public class TipoProductoView {

	private final TipoProductoService tipoProductoService = new TipoProductoServiceImpl();
	private DefaultTableModel defaultTableModel;
	private TipoProducto tipoProducto = null;

	private JPanel tipoProductoPanel;

	private JTextField txtNombre;

	private JButton btnGuardar;

	private JButton btnCancelar;

	private JButton btnEditar;

	private JButton btnEliminar;

	private JTable table_tipo_producto;


	public TipoProductoView() {
		initComponents();
		this.defaultTableModel = (DefaultTableModel) table_tipo_producto.getModel();
		cargarTipoProductos();

		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
			}
		});


		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				TipoProducto tipoProducto = new TipoProducto(nombre);
				tipoProductoService.agregarTipoProducto(tipoProducto);
				Messages.success("Producto guardado correctamente.");
				cargarTipoProductos();

			}
		});
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer id = getId();
				if(id!=null){
					tipoProducto = tipoProductoService.findById(id);
					cargarTipoProducto(tipoProducto);
				}
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer id = getId();
				if (id != null) {
					TipoProducto other = new TipoProducto(id);
					tipoProductoService.removerTipoProducto(other);
					Messages.success("Producto eliminado correctamente.");
					cargarTipoProductos();
				}else{
					Messages.info("Seleccione un producto.");
				}
			}
		});
	}

	private void initComponents() {

		table_tipo_producto.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"ID", "Nombre"
				}
		) {
			boolean[] canEdit = new boolean [] {
					false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});

	}

	public void cargarTipoProducto(TipoProducto tipoProducto){
		txtNombre.setText(tipoProducto.getNombre());
	}


	private Integer getId(){
		if(table_tipo_producto.getSelectedRowCount() > 0){
			Integer row = table_tipo_producto.getSelectedRow();
			return Integer.parseInt(table_tipo_producto.getValueAt(row, 0).toString());
		}
		return null;
	}

	public void cargarTipoProductos() {
		limpiarTabla();
		for (TipoProducto tipoProducto : tipoProductoService.getTiposProductos()) {
			defaultTableModel.addRow(new Object[]{
					tipoProducto.getId(), tipoProducto.getNombre()
			});
		}
	}

	public void limpiarTabla() {
		int rows = defaultTableModel.getRowCount();
		for (int i = 0; i < rows; i++) {
			defaultTableModel.removeRow(0);
		}
	}

	public JPanel getTipoProductoPanel() {
		return tipoProductoPanel;
	}



}
