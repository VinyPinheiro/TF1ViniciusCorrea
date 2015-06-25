package validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data.Person;

public class Validator {
	public static boolean isValidString(String value) {
		return ((value.isEmpty()) ? false : true);
	}

	public static boolean isPositiveNumber(Integer value) {
		return ((value < 0) ? false : true);
	}

	public static boolean isValidDate(String value) {
		SimpleDateFormat format;
		
		format = new SimpleDateFormat("dd/MM/yyyy");
		
		format.setLenient(false);
		try {
			format.parse(value);
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

	private static int calculateDV(Long cpf) {
		final int DV1CPFLENGHT = 10;
		final int DV2CPFLENGHT = 11;
		long number;
		int dv;
		int aux;

		aux = 0;
		number = cpf/100;

		for (int i = 1; i <= DV1CPFLENGHT; i++) {
			aux += (int) (number % 10 * (i + 1));
			number /= 10;
		}
		
		dv = (aux % DV2CPFLENGHT < 2) ? 0 : DV2CPFLENGHT - aux % DV2CPFLENGHT;
		
		number = cpf/100;
		number *= 10;
		number += dv;
		dv *= 10;
		aux = 0;
		
		for (int i = 1; i <= DV2CPFLENGHT; i++) {
			aux += (int) (number % 10 * (i + 1));
			number /= 10;
		}

		dv += (aux % DV2CPFLENGHT < 2) ? 0 : DV2CPFLENGHT - aux % DV2CPFLENGHT;
		return dv;
	}
	
	public static boolean isValidCpf(Long cpf)
	{
		if(calculateDV(cpf) == cpf % 100)
			return true;
		else
			return false;
	}
}
