package pe.joedayz.supermercado.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ProductosView extends JFrame {
	private JPanel productosPanel;

	private JTextField textField1;

	private JTextField textField2;

	private JComboBox comboBox1;

	private JButton guardarButton;

	private JButton cancelarButton;

	private JButton editarButton;

	private JButton eliminarButton;

	private JTable table1;

	public JPanel getProductosPanel() {
		return productosPanel;
	}
}
