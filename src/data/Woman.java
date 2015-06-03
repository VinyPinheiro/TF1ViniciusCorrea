package data;

import java.util.Date;

public class Woman extends Person {

	private Integer numberOfTimesPregnant;

	public Woman(String name, Character sex, Date dateVaccination, Long cpf,
			Integer numberOfTimesPregnant) {
		super(name, sex, dateVaccination, cpf);
		setNumberOfTimesPregnant(numberOfTimesPregnant);
	}

	public Integer getNumberOfTimesPregnant() {
		return numberOfTimesPregnant;
	}

	public void setNumberOfTimesPregnant(Integer numberOfTimesPregnant) {
		this.numberOfTimesPregnant = numberOfTimesPregnant;
	}

	public String toString() {
		return null;
	}
}
