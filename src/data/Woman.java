package data;

public class Woman extends Person {

	private Integer numberOfTimesPregnant;

	public Woman(String name, Character sex, String dateVaccination, Long cpf,
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
		return getName() + "\t\t" + ((getSex().equals('M')) ? "Homem" : "Mulher")
				+ "\t\t" + getDateVaccination() + "\t\t" + getCpf() + "\t\t"
				+ getNumberOfTimesPregnant();
	}
}
