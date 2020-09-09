package pe.joedayz.supermercado;

import javax.swing.JOptionPane;

public class Messages {

	public static void error(String message){
		JOptionPane.showMessageDialog(null, message, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void success(String message){
		JOptionPane.showMessageDialog(null, message, "Mensaje de información", JOptionPane.OK_OPTION);
	}

	public static void info(String message){
		JOptionPane.showMessageDialog(null, message, "Mensaje de información", JOptionPane.INFORMATION_MESSAGE);
	}
}
