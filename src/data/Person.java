package data;

import java.util.Date;

public class Person {

	private StringBuilder name;
	private Character sex;
	private Date dateVaccination;
	private Long cpf;

	public Person(String name, Character sex, Date dateVaccination, Long cpf) {
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

	public Date getDateVaccination() {
		return dateVaccination;
	}

	public void setDateVaccination(Date dateVaccination) {
		this.dateVaccination = dateVaccination;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

}
