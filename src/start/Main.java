package start;

import vision.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import validator.Validator;

public class Main {

	public static void main(String[] args) {
		JFrame window = new Menu();
		window.setVisible(true);
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
