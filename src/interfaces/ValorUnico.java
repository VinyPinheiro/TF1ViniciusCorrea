package interfaces;

import data.Person;

public interface ValorUnico {
	boolean isUnique(Long cpf, Person[] people);
}
