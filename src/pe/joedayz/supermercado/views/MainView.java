package pe.joedayz.supermercado.views;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainView extends JFrame {


	private javax.swing.JTabbedPane tab_main;
	private final ClienteView clienteView = new ClienteView();
	private final VendedorView vendedorView = new VendedorView();
	private final ProductosView productosView = new ProductosView();

	public MainView() {
		initComponents();

		tab_main.addTab("Clientes", clienteView);
		tab_main.addTab("Vendedores", vendedorView);
		tab_main.addTab("Productos", productosView);

		tab_main.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() instanceof JTabbedPane) {
					JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
					
				}
			}
		});
	}

	private void initComponents() {
		tab_main = new javax.swing.JTabbedPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Supermercado");
		setMaximumSize(new java.awt.Dimension(800, 600));
		setMinimumSize(new java.awt.Dimension(800, 600));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tab_main, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tab_main, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
								.addContainerGap())
		);

		pack();
	}
}
