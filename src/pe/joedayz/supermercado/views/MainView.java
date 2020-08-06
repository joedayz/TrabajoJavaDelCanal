package pe.joedayz.supermercado.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainView extends JFrame {
	private JTabbedPane tabMain;

	private JPanel panelPrincipal;

	public MainView(){
		this.setContentPane(this.panelPrincipal);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();

		createUIComponents();

	}

	private void createUIComponents() {
		tabMain.addTab("Clientes", new ClienteView().getClientePanel());
		tabMain.addTab("Vendedores", new VendedorView().getVendedorPanel());
	}
}
