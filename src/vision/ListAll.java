package vision;

import java.util.ArrayList;

import data.Person;

public class ListAll {
	public static void listPeople(ArrayList<Person> people) {
		int totalWoman, totalMen;
		
		totalMen = 0;
		totalWoman = 0;
		
		System.out
				.println("Nome\t\t\t\t\tSexo\t\tÚltima Vacinação\t\tCPF\t\tEstado Civil/Numero de vezes que engravidou");
		
		for (Person person : people) {
			if(person.getSex().equals('M'))
				totalMen++;
			else
				totalWoman++;
			
			System.out.println(person);
		}

		System.out.println("Total de Mulheres: " + totalWoman);
		System.out.println("Total de Homens: " + totalMen);
		System.out.println("Total de Cadastros: " + (totalWoman + totalMen));
	}
}
