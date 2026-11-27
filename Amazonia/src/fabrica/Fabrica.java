package fabrica;

import static com.accesodatos.Configuracion.*;

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
