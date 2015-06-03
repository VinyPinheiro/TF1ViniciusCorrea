package data;

import java.util.Date;

public class Men extends Person {

	private String relationship;

	public Men(String name, Character sex, Date dateVaccination, Long cpf,
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
	public String toString()
	{
		return null;
	}
}
