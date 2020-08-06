package pe.joedayz.supermercado;

import pe.joedayz.supermercado.views.MainView;

public class Main {

    public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainView().setVisible(true);
			}
		});
	}

}
