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
}
