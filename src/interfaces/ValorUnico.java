package interfaces;

import java.util.ArrayList;

import data.Person;

public interface ValorUnico {
	boolean isUniqueCpf(Long cpf, ArrayList<Person> people);
}
