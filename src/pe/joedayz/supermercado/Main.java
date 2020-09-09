package pe.joedayz.supermercado;

import pe.joedayz.supermercado.views.MainView;

public class Main {

    public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info:javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException |
				IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainView().setVisible(true);
			}
		});
	}

}
