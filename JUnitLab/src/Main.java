public class Main {

	public static void main(String[] args) {
		boolean[] resets = { true, true, true };
		if (esEmpirico(resets)) {
			System.out.println("tal cual hermano");
		} else {
			System.out.println("huh");
		}
		
		try {
            String password = "Ejemplo1";
            if (passwordValidator(password)) {
                System.out.println("El password es válido.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
	}

	// EJERCICIO 1 (3 PUNTOS)
	// Crea una función que recibe un password y compruebe que cumple los siguientes
	// requisitos:
	// - Tener al menos 8 caracteres
	// - Tener al menos una mayúscula
	// - Tener al menos una minúscula
	// Si cumple todos los requisitos debería devolver true, en caso contrario
	// debería devolver un error con la causa
	public static boolean passwordValidator(String password) throws Exception {
		if (tiene8Caracteres(password) && tieneMinuscilas(password) && tieneMayusculas(password)) {
			return true;
		}
		throw new Exception("La contraseña no es valida.");
	}

	private static boolean tiene8Caracteres(String password) throws Exception{
		if (password.length() >= 8) {
            return true;
        } else {
            throw new Exception("El password debe tener al menos 8 caracteres.");
        }
	}

	private static boolean tieneMinuscilas(String password) throws Exception{
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		throw new Exception("El password debe contener al menos una minúscula.");
	}

	private static boolean tieneMayusculas(String password) throws Exception{
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		throw new Exception("El password debe contener al menos una mayúscula.");
	}


	// EJERCICIO 2 (2 PUNTOS)
	// Refactoriza el código para que sea lo más limpio posible.

	// EJERCICIO 3 (3 PUNTOS)
	// Crea una clase de test que pruebe el método passwordValidator y los casos de
	// prueba que consideres necesarios.

	// EJERCICIO 4 (2 PUNTOS)
	// Encuentra y arregla el error en este código sabiendo que esEmpirico devuelve
	// true si todos los valores del array
	// son iguales a true.
	// He cambiado el indice del bucle for para que empiece por 0 y recorra todo el array, tambien he quietado el = de la condicion
	// del bucle, he restado 1 al tamaño del array en el if para que sea correcto y en el metodo comprueba es el ultimo con el
	// indice basta no hace falta restarle 1.
	public static boolean esEmpirico(boolean[] resets) {
		boolean talCual = true;
		for (int i = 0; i < resets.length; i++) {
			if (i == resets.length - 1) {
				talCual = compruebaResetUltimo(resets, i, talCual);
			} else {
				talCual = compruebaReset(talCual, resets[i]);
			}
		}
		return talCual;
	}

	private static boolean compruebaReset(boolean talCual, boolean resets) {
		return resets && talCual;
	}

	private static boolean compruebaResetUltimo(boolean[] resets, int i, boolean talCual) {
		return resets[i] && talCual;
	}
}