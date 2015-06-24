/*
 * Sintese
 * 	Entrada: Nome, Ultima vacinação, cpf, sexo, Estado Civil ou Numero de vezes que engravidou
 * 	Saida: Nome, Ultima vacinação, cpf, sexo, Estado Civil ou Numero de vezes que engravidou
 * 
 * */

package start;

import vision.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import data.Person;

public class Main {

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		
		JFrame window = new Menu(people);
		
		window.setVisible(true);
		
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
