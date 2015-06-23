package data;

import java.util.ArrayList;

public class SecretariaSaude {

	private ArrayList<Person> people;

	public SecretariaSaude() {
		people = new ArrayList<Person>();
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public Person findPerson(final Long cpf) {
		for (Person person : people) {
			if (person.getCpf().equals(cpf))
				return person;
		}
		return null;
	}
	
	public void addPerson(String name, String date, String cpf,
			String numberOfTimesPregnant) {
		Woman woman = new Woman(name, 'F', date, Long.parseLong(cpf),
				Integer.parseInt(numberOfTimesPregnant));
		people.add(woman);

	}

	public void addPerson(String name, String date, String cpf, int relationship) {
		String[] options = getRelationshipOptions();
		Men men = new Men(name, 'M', date, Long.parseLong(cpf),
				options[relationship]);
		people.add(men);
	}
	
	public String[] getRelationshipOptions()
	{
		String[] options = { "Solteiro", "Casado", "Viúvo", "Separado" };
		return options;
	}
	
	public String toString()
	{
		int totalWoman, totalMen;
		String text;
		
		totalMen = 0;
		totalWoman = 0;
		
		text = ("Nome\t\t\t\t\tSexo\t\tÚltima Vacinação\t\tCPF\t\tEstado Civil/Numero de vezes que engravidou");
		
		for (Person person : people) {
			
			if(person.getSex().equals('M'))
				totalMen++;
			else
				totalWoman++;
			
			text +="\n" + person.toString();
		}

		text += "\n" + ("Total de Mulheres: " + totalWoman);
		text += "\n" + ("Total de Homens: " + totalMen);
		text += "\n" + ("Total de Cadastros: " + (totalWoman + totalMen));
		
		return text;
	}
}
