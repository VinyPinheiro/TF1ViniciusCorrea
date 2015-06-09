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
	private JComboBox comboRelationship;
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
	
	public Register()
	{
		setTitle("Cadastrar");
		setBounds(100, 100, 300, 351);
		contains = getContentPane();
		contains.setBackground(new Color(0, 128, 128));
		contains.setLayout(new GridLayout(6, 1));
		
		textName = new JTextField();
		
		labelName = new JLabel();
		labelName.setText("Nome");
		
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(1,20,40));
		p1.add(labelName);
		p1.add(textName);
		
		
		contains.add(p1);
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
