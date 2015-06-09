package vision;

import java.util.ArrayList;

import data.Person;

public class ListAll {
	public static void listPeople(ArrayList<Person> people) {
		System.out
				.println("Nome\t\t\t\t\tSexo\t\tÚltima Vacinação\t\tCPF\t\tEstado Civil/Numero de vezes que engravidou");
		for (Person person : people) {
			System.out.println(person);
		}
	}
}
