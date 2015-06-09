package vision;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Register extends JFrame implements ActionListener, ItemListener,
		ListSelectionListener {

	private JTextField textName;
	private JLabel labelName;
	private JTextField textDate;
	private JLabel labelDate;
	private JTextField textCpf;
	private JLabel labelCpf;
	private JRadioButton radioman;
	private JRadioButton radiowoman;
	private JComboBox<String> comboRelationship;
	private JLabel labelRelationship;
	private JTextField textNumberOfTimesPregnant;
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

	public Register() {
		setTitle("Cadastrar");
		setBounds(100, 100, 600, 400);
		contains = getContentPane();
		contains.setBackground(new Color(0, 128, 128));
		contains.setLayout(new GridLayout(6,1));

		textName = new JTextField();
		textName.setColumns(50);

		labelName = new JLabel();
		labelName.setText("Nome:");

		p1 = new JPanel();
		p1.setLayout(new FlowLayout(0));
		p1.add(labelName);
		p1.add(textName);

		textDate = new JTextField();
		textDate.setColumns(10);
		
		labelDate = new JLabel();
		labelDate.setText("Data de Nascimento:");

		textCpf = new JTextField();
		textCpf.setColumns(20);

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
		radioman.setText("Homem");
		radioman.setSelected(true);
		radioman.addItemListener(this);
		
		radiowoman = new JRadioButton();
		radiowoman.setText("Mulher");
		radiowoman.addItemListener(this);
		
		radiogroup = new ButtonGroup();
		radiogroup.add(radioman);
		radiogroup.add(radiowoman);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(1));
		p3.add(radioman);
		p3.add(radiowoman);

		String[] options = {"Soteiro","Casado","Viuvo", "Separado"};
		comboRelationship = new JComboBox<String>(options);
		
		labelRelationship = new JLabel();
		labelRelationship.setText("Estado Civil");
		
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(0));
		p4.add(labelRelationship);
		p4.add(comboRelationship);
		
		textNumberOfTimesPregnant = new JTextField();
		textNumberOfTimesPregnant.setColumns(5);
		textNumberOfTimesPregnant.setEnabled(false);
		
		labelNumberOfTimesPregnant = new JLabel();
		labelNumberOfTimesPregnant.setText("Numero de vezes que já engravidou");
		
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(0));
		p5.add(labelNumberOfTimesPregnant);
		p5.add(textNumberOfTimesPregnant);
		
		buttonSave = new JButton();
		buttonSave.setText("Salvar");

		p6 = new JPanel();
		p6.setLayout(new GridLayout(1,1));
		p6.add(buttonSave);
		
		contains.add(p1);
		contains.add(p2);
		contains.add(p3);
		contains.add(p4);
		contains.add(p5);
		contains.add(p6);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
