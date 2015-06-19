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

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import data.Men;
import data.Person;
import data.SecretariaSaude;
import data.Woman;

import validator.Validator;

public class Consult extends JFrame implements ActionListener, WindowListener {

	private SecretariaSaude data;

	private JFormattedTextField textCpf;
	private JLabel labelCpf;
	private JButton buttonFind;
	private Container contains;

	public Consult(SecretariaSaude data) {

		this.data = data;

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
			Person person = data.findPerson(Long.parseLong(textCpf.getText()));

			if (person == null)
				JOptionPane.showMessageDialog(this, "Nao encontrado",
						"Consulta", JOptionPane.PLAIN_MESSAGE);
			else {
				if (person.getSex().equals('M')) {

					JOptionPane.showMessageDialog(
							this,
							"Nome: " + person.getName() + "\nCPF: "
									+ person.getCpf().toString()
									+ "\nÚltima Vacinação: "
									+ person.getDateVaccination()
									+ "\nSexo: Masculino" + "\nEstado Civil: "
									+ ((Men) person).getRelationship(),
							"Consulta", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(
							this,
							"Nome: "
									+ person.getName()
									+ "\nCPF: "
									+ person.getCpf().toString()
									+ "\nÚltima Vacinação: "
									+ person.getDateVaccination()
									+ "\nSexo: Feminino"
									+ "\nNumero de gravides: "
									+ ((Woman) person)
											.getNumberOfTimesPregnant()
											.toString(), "Consulta",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
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

}