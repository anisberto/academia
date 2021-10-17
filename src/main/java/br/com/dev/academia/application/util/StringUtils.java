package br.com.dev.academia.application.util;

public class StringUtils {

	public static boolean isEmpty(String elemento) {

		if (elemento == null) {
			return true;
		}

		return elemento.trim().length() == 0;
	}

	public static String leftZeros(int value, int finalSize) {
		return String.format("%0" + finalSize + "d", value);
	}

}
