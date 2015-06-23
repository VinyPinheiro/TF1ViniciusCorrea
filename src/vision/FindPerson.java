package vision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import data.Men;
import data.Person;
import data.SecretariaSaude;
import data.Woman;

public class FindPerson extends JFrame implements KeyListener {

	private SecretariaSaude data;

	private JLabel labelTotal;
	private JTextField textName;
	private JLabel labelName;
	private JTable tableData;
	private JScrollPane scrollTableData;
	private Container contains;
	private DefaultTableModel table;
	private JPanel p;

	public FindPerson(SecretariaSaude data) {
		this.data = data;

		setTitle("Buscar");
		setBounds(100, 100, 600, 600);
		contains = getContentPane();
		contains.setBackground(Color.GRAY);
		contains.setLayout(new BorderLayout());

		textName = new JTextField();
		textName.setColumns(40);
		textName.addKeyListener(this);

		labelName = new JLabel();
		labelName.setText("Nome:");

		p = new JPanel();
		p.setLayout(new FlowLayout(-1));

		p.add(labelName);
		p.add(textName);

		table = new DefaultTableModel();

		tableData = new JTable(table);
		table.addColumn("Nome");
		table.addColumn("CPF");
		table.addColumn("Sexo");
		table.addColumn("Última Vacinação");
		table.addColumn("Estado Civil/Numero de gravidez");
		matrizPeople("");

		labelTotal = new JLabel();
		labelTotal.setText("Total de Cadastros: " + table.getRowCount());

		scrollTableData = new JScrollPane(tableData);

		contains.add("North", p);
		contains.add("Center", scrollTableData);
		contains.add("South", labelTotal);
	}

	private void matrizPeople(String part) {
		List<Person> people = data.getPeople();
		String[] rows = new String[5];
		Collections.sort(people);
		table.setNumRows(0);

		for (int i = 0; i < people.size(); i++) {
			if (!(people.get(i).getName().toLowerCase()).contains(part
					.toLowerCase()) && !part.isEmpty())
				continue;
			rows[0] = people.get(i).getName();
			rows[1] = people.get(i).getCpf().toString();
			rows[3] = people.get(i).getDateVaccination();
			if (people.get(i).getSex().equals('M')) {
				rows[2] = "Masculino";
				rows[4] = ((Men) people.get(i)).getRelationship();
			} else {
				rows[2] = "Feminino";
				rows[4] = ((Woman) people.get(i)).getNumberOfTimesPregnant()
						.toString();
			}
			
			table.addRow(rows);

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		matrizPeople(textName.getText());

		labelTotal.setText("Total de Cadastros: " + table.getRowCount());

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
