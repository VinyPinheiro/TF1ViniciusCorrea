package data;

public class Man extends Person {

	private String relationship;

	public Man(String name, Character sex, String dateVaccination, Long cpf,
			String relationship) {
		super(name, sex, dateVaccination, cpf);
		setRelationship(relationship);
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String toString() {
		return getName() + "\t\t" + ((getSex().equals('M')) ? "Homem" : "Mulher")
				+ "\t\t" + getDateVaccination() + "\t\t" + getCpf() + "\t\t"
				+ getRelationship();
	}
}
