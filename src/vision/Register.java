package vision;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import data.SecretariaSaude;

import validator.Validator;

public class Register extends JFrame implements ActionListener, ItemListener,
		WindowListener {

	private SecretariaSaude data;

	private JTextField textName;
	private JLabel labelName;
	private JFormattedTextField textDate;
	private JLabel labelDate;
	private JFormattedTextField textCpf;
	private JLabel labelCpf;
	private JRadioButton radioman;
	private JRadioButton radiowoman;
	private JComboBox<String> comboRelationship;
	private JLabel labelRelationship;
	private JFormattedTextField textNumberOfTimesPregnant;
	private JLabel labelNumberOfTimesPregnant;
	private JButton buttonSave;
	private ButtonGroup radiogroup;
	private Container contains;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;
	private JPanel p6;

	public Register(SecretariaSaude data) {

		this.data = data;

		setTitle("Cadastrar");
		setBounds(100, 100, 600, 400);
		contains = getContentPane();
		contains.setBackground(new Color(0, 128, 128));
		contains.setLayout(new GridLayout(6, 1));

		textName = new JTextField();
		textName.setColumns(50);

		labelName = new JLabel();
		labelName.setText("Nome:");

		p1 = new JPanel();
		p1.setLayout(new FlowLayout(0));
		p1.add(labelName);
		p1.add(textName);

		try {
			textDate = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			System.out.println("Erro na criação da janela");
			System.exit(0);
		}
		textDate.setColumns(10);
		textDate.setToolTipText("Ex.: 14/02/1995");

		labelDate = new JLabel();
		labelDate.setText("Data da Última Vacinação:");

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

		p2 = new JPanel();
		p2.setLayout(new FlowLayout(0));
		p2.add(labelDate);
		p2.add(textDate);
		p2.setLayout(new FlowLayout(0));
		p2.add(labelCpf);
		p2.add(textCpf);

		radioman = new JRadioButton();
		radioman.setText("Masculino");
		radioman.setSelected(true);
		radioman.addItemListener(this);

		radiowoman = new JRadioButton();
		radiowoman.setText("Feminino");
		radiowoman.addItemListener(this);

		radiogroup = new ButtonGroup();
		radiogroup.add(radioman);
		radiogroup.add(radiowoman);

		p3 = new JPanel();
		p3.setLayout(new FlowLayout(1));
		p3.add(radioman);
		p3.add(radiowoman);

		String[] options = data.getRelationshipOptions();
		comboRelationship = new JComboBox<String>(options);

		labelRelationship = new JLabel();
		labelRelationship.setText("Estado Civil");

		p4 = new JPanel();
		p4.setLayout(new FlowLayout(0));
		p4.add(labelRelationship);
		p4.add(comboRelationship);

		try {
			textNumberOfTimesPregnant = new JFormattedTextField(
					new MaskFormatter("##"));
		} catch (ParseException e) {
			System.out.println("Erro na criação da janela");
			System.exit(0);
		}
		textNumberOfTimesPregnant.setColumns(5);
		textNumberOfTimesPregnant.setVisible(false);
		textNumberOfTimesPregnant.setToolTipText("Ex.: 02, 10, 01, 05, ...");

		labelNumberOfTimesPregnant = new JLabel();
		labelNumberOfTimesPregnant.setText("Número de vezes que já engravidou(2 digitos Ex: 01)");
		labelNumberOfTimesPregnant.setVisible(false);

		p5 = new JPanel();
		p5.setLayout(new FlowLayout(0));
		p5.add(labelNumberOfTimesPregnant);
		p5.add(textNumberOfTimesPregnant);

		buttonSave = new JButton();
		buttonSave.setText("Salvar");
		buttonSave.addActionListener(this);

		p6 = new JPanel();
		p6.setLayout(new GridLayout(1, 1));
		p6.add(buttonSave);

		contains.add(p1);
		contains.add(p2);
		contains.add(p3);
		contains.add(p4);
		contains.add(p5);
		contains.add(p6);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == radioman) {
			textNumberOfTimesPregnant.setVisible(false);
			comboRelationship.setVisible(true);
			labelRelationship.setVisible(true);
			labelNumberOfTimesPregnant.setVisible(false);
		} else if (e.getSource() == radiowoman) {
			textNumberOfTimesPregnant.setVisible(true);
			comboRelationship.setVisible(false);
			labelRelationship.setVisible(false);
			labelNumberOfTimesPregnant.setVisible(true);
		}

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

		if (!Validator.isValidDate(textDate.getText())) {
			JOptionPane.showMessageDialog(null, "Data invalida", "ERRO", 0);
			return;
		}

		if (!Validator.isValidString(textName.getText())) {
			JOptionPane.showMessageDialog(null, "Nome não pode ser vazio",
					"ERRO", 1);
			return;
		}
		
		if(!data.isUniqueCpf(Long.parseLong(textCpf.getText())))
		{
			JOptionPane.showMessageDialog(null, "CPF já cadastrado",
					"ERRO", 1);
			return;
		}

		if (radiowoman.isSelected()) {

			if (!Validator.isValidString(textNumberOfTimesPregnant.getText()
					.trim())) {
				JOptionPane.showMessageDialog(null,
						"Insira o Número de vezes que a pessoa já engravidou",
						"ERRO", 0);
				return;
			}

			if (!Validator.isPositiveNumber(Integer
					.parseInt(textNumberOfTimesPregnant.getText().trim()))) {
				JOptionPane
						.showMessageDialog(
								null,
								"Reinsira o Número de vezes que a pessoa já engravidou(Valor negativo invalido)",
								"ERRO", 0);
				return;
			}

			data.addPerson(textName.getText().trim(), textDate.getText(), textCpf
					.getText().trim(), textNumberOfTimesPregnant.getText());

		} else {
			data.addPerson(textName.getText().trim(), textDate.getText(), textCpf
					.getText().trim(), comboRelationship.getSelectedIndex());

		}

		JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Salvo", 1);

		this.dispose();
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
