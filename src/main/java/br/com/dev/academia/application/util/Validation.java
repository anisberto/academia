package br.com.dev.academia.application.util;

public class Validation {

	public static void assertNotEmpty(Object elemento) {

		if (elemento instanceof String) {
			String item = (String) elemento;

			if (StringUtils.isEmpty(item)) {
				throw new ValidationException("Estring vazia");
			}
		}

		if (elemento == null) {
			throw new ValidationException("Estring nula");
		}
	}
}
