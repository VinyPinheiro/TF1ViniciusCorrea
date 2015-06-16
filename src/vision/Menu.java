package vision;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

import data.Person;

import sun.util.BuddhistCalendar;

public class Menu extends JFrame implements ActionListener {

	private ArrayList<Person> people;

	private JButton buttonRegister;
	private JButton buttonConsult;
	private JButton buttonListAll;
	private JButton buttonFindPerson;
	private JButton buttonClose;
	private Container contains = getContentPane();

	public Menu(ArrayList<Person> people) {

		this.people = people;

		setTitle("Menu Inicial");
		setBounds(100, 100, 300, 351);
		contains.setBackground(new Color(0, 128, 128));
		contains.setLayout(new GridLayout(5, 1));

		buttonRegister = new JButton();
		buttonRegister.setText("Cadastrar");
		buttonRegister.addActionListener(this);

		buttonConsult = new JButton();
		buttonConsult.setText("Pesquisar CPF");
		buttonConsult.addActionListener(this);

		buttonRegister = new JButton();
		buttonRegister.setText("Cadastrar");
		buttonRegister.addActionListener(this);

		buttonListAll = new JButton();
		buttonListAll.setText("Listar Todos");
		buttonListAll.addActionListener(this);

		buttonFindPerson = new JButton();
		buttonFindPerson.setText("Pesquisar Nome");
		buttonFindPerson.addActionListener(this);

		buttonClose = new JButton();
		buttonClose.setText("Fechar");
		buttonClose.addActionListener(this);

		contains.add(buttonRegister);
		contains.add(buttonListAll);
		contains.add(buttonFindPerson);
		contains.add(buttonConsult);
		contains.add(buttonClose);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonClose) {
			System.exit(0);
		} else if (e.getSource() == buttonRegister) {
			JFrame register = new Register(people);
			register.setVisible(true);
		} else if (e.getSource() == buttonListAll) {
			ListAll.listPeople(people);
		} else if (e.getSource() == buttonConsult) {
			JFrame consult = new Consult(people);
			consult.setVisible(true);
		} else if (e.getSource() == buttonFindPerson) {
			JFrame find = new findPerson(people);
			find.setVisible(true);
		}

	}
}
