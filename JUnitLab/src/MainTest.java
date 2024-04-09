import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    @DisplayName("Probamos una contraseña valida.")
    public void contraseñaValida() {
        String password = "Ejemplo123";
        try {
            assertTrue(Main.passwordValidator(password));
        } catch (Exception e) {
            fail("Se lanzó una excepción: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Probamos una contraseña que no tenga 8 caractes")
    public void contraseñaCorta() {
        String password = "abc123";
        try {
            assertFalse(Main.passwordValidator(password));
        } catch (Exception e) {
            assertEquals("El password debe tener al menos 8 caracteres.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Probamos una contraseña valida.")
    public void contraseñaSinMinusculas() {
        String password = "EJEMPLO123";
        try {
            assertFalse(Main.passwordValidator(password));
        } catch (Exception e) {
            assertEquals("El password debe contener al menos una minúscula.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Probamos una contraseña valida.")
    public void contraseñaSinMayusculas() {
        String password = "ejemplo123";
        try {
            assertFalse(Main.passwordValidator(password));
        } catch (Exception e) {
            assertEquals("El password debe contener al menos una mayúscula.", e.getMessage());
        }
    }
}

