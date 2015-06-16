package vision;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import data.Men;
import data.Person;
import data.Woman;

import validator.Validator;

public class Consult extends JFrame implements ActionListener, WindowListener {

	private ArrayList<Person> people;

	private JFormattedTextField textCpf;
	private JLabel labelCpf;
	private JButton buttonFind;
	private Container contains;

	public Consult(ArrayList<Person> people) {

		this.people = people;

		setTitle("Cadastrar");
		setBounds(100, 100, 400, 100);
		contains = getContentPane();
		contains.setBackground(new Color(128, 128, 128));
		contains.setLayout(new FlowLayout(-1));

		try {
			textCpf = new JFormattedTextField(new MaskFormatter("###########"));
		} catch (ParseException e) {
			System.out.println("Erro na criação da janela");
			System.exit(0);
		}
		textCpf.setColumns(20);
		textCpf.setToolTipText("Apenas Números");

		labelCpf = new JLabel();
		labelCpf.setText("CPF:");

		buttonFind = new JButton();
		buttonFind.setText("Procurar");
		buttonFind.addActionListener(this);

		contains.add(labelCpf);
		contains.add(textCpf);
		contains.add(buttonFind);
	}

	private Person findPerson(final Long cpf) {
		for (Person person : people) {
			if (person.getCpf().equals(cpf))
				return person;
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!Validator.isValidString(textCpf.getText().trim())) {
			JOptionPane.showMessageDialog(null, "CPF não pode ser vazio",
					"ERRO", 0);
			return;
		}

		if (!Validator.isValidCpf(Long.parseLong(textCpf.getText()))) {
			JOptionPane.showMessageDialog(null, "CPF invalido", "ERRO", 0);
			return;
		}
		if (e.getSource() == buttonFind) {
			final JFrame consult = new ConsultResult(findPerson(Long.parseLong(textCpf.getText())));
			
			consult.setVisible(true);
			
			consult.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					consult.dispose();
				}
			});
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		this.dispose();

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public class ConsultResult extends JFrame {
		private JLabel name;
		private JLabel cpf;
		private JLabel sex;
		private JLabel dateVaccination;
		private JLabel other;
		private Container contain;

		public ConsultResult(Person person) {
			setTitle("Consulta");
			contain = getContentPane();

			if (person == null) {
				setBounds(100, 100, 400, 100);
				contain.setLayout(new GridLayout(1, 1));
				name = new JLabel("Não encontrado");
				contain.add(name);
			} else {
				setBounds(100, 100, 400, 300);
				contain.setLayout(new GridLayout(5, 1));
				name = new JLabel("Nome:" + person.getName());
				cpf = new JLabel("CPF: " + person.getCpf().toString());
				dateVaccination = new JLabel("Última Vacinação: "
						+ person.getDateVaccination());
				if (person.getSex().equals('M')) {
					sex = new JLabel("Sexo: Masculino");
					other = new JLabel("Estado Civil: "
							+ ((Men) person).getRelationship());
				} else {
					sex = new JLabel("Sexo: Feminino");
					other = new JLabel("Numero de gravides: "
							+ ((Woman) person).getNumberOfTimesPregnant()
									.toString());
				}
				contain.add(name);
				contain.add(cpf);
				contain.add(dateVaccination);
				contain.add(other);
			}
		}
	}
}
