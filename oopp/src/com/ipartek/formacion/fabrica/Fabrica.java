package com.ipartek.formacion.fabrica;

import static com.ipartek.formacion.oop.accesodatos.Configuracion.PROPS;

public class Fabrica {

	public static Object fabricar(String clave) {

		String clase = PROPS.getProperty(clave);

		try {
			return Class.forName(clase).getDeclaredConstructor().newInstance();

		} catch (Exception e) {
			throw new RuntimeException("Error al fabricar objeto: " + clave, e);
		}
	}
}
