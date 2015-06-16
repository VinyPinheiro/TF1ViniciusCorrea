package data;

public class Person implements Comparable{

	private StringBuilder name;
	private Character sex;
	private String dateVaccination;
	private Long cpf;

	public Person(String name, Character sex, String dateVaccination, Long cpf) {
		setName(name);
		setSex(sex);
		setDateVaccination(dateVaccination);
		setCpf(cpf);
	}

	public String getName() {
		return name.toString();
	}

	public void setName(String name) {
		this.name = new StringBuilder(name);
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getDateVaccination() {
		return dateVaccination;
	}

	public void setDateVaccination(String dateVaccination) {
		this.dateVaccination = dateVaccination;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public int compareTo(Object objeto) {
		Person person = (Person) objeto;
		return getName().compareTo(person.getName());
	}
}
