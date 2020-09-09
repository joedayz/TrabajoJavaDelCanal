package pe.joedayz.supermercado.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainView extends JFrame {
	private JTabbedPane tabMain;

	private JPanel panelPrincipal;

	public MainView(){
		initComponents();

		createUIComponents();

	}

	private void initComponents() {
		setContentPane(this.panelPrincipal);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Supermercado");
		setMaximumSize(new java.awt.Dimension(800, 600));
		setMinimumSize(new java.awt.Dimension(800, 600));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabMain, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabMain, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
								.addContainerGap())
		);

		this.pack();
	}

	private void createUIComponents() {
		tabMain.addTab("Clientes", new ClienteView().getClientePanel());
		tabMain.addTab("Vendedores", new VendedorView().getVendedorPanel());
		tabMain.addTab("Productos", new ProductosView().getProductosPanel());
		tabMain.addTab("Tipo Producto", new TipoProductoView().getTipoProductoPanel());
		tabMain.addTab("Venta", new VentaView().getVentaPanel());

	}
}
