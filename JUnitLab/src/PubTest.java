import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PubTest {

    private Pub pub;

    @BeforeEach
    public void setUp() throws Exception {
        pub = new Pub();
    }

    @Test
    @DisplayName("Cuando pedimos una cerveza el precio tiene que ser 5 €.")
    public void unaCervezaTest() {
        int coste = pub.calcularPrecio(Pub.CERVEZA, false, 1, 0);
        assertEquals(5, coste);
    }
    
    @Test
    @DisplayName("Cuando pedimos una cerveza con hielo no puede ser.")
    public void unaCervezaHieloTest() {
        assertThrows(RuntimeException.class, () -> pub.calcularPrecio(Pub.CERVEZA, false, 1, 1));
    }

    @Test
    @DisplayName("Cuando pedimos un vino tinto el precio tiene que ser 2 €.")
    public void unVinoTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.VINO, false, 1, 0);
        assertEquals(2, coste);
    }
    
    @Test
    @DisplayName("Cuando pedimos un vino tinto con dos hielo el precio tiene que ser 4 €.")
    public void unVinoHieloTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.VINO, false, 1, 2);
        assertEquals(4, coste);
    }
    
    @Test
    @DisplayName("Cuando pedimos dos vinos tintos con un hielo el precio tiene que ser 6 €.")
    public void dosVinoHieloTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.VINO, false, 2, 1);
        assertEquals(6, coste);
    }

    @Test
    @DisplayName("Cuando pedimos una sidra el precio tiene que ser 2 €.")
    public void unaSidraTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.SIDRA, false, 1, 0);
        assertEquals(2, coste);
    }
    
    @Test
    @DisplayName("Cuando pedimos una sidra con un hielo el precio tiene que ser 3 €.")
    public void unaSidraHieloTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.SIDRA, false, 1, 1);
        assertEquals(3, coste);
    }


    @Test
    @DisplayName("Cuando pedimos un sex on the beach el precio tiene que ser 8 €.")
    public void unCocktailTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.SEX_ON_THE_BEACH, false, 1, 0);
        assertEquals(8, coste);
    }
    
    @Test
    @DisplayName("Cuando pedimos un sex on the beach con un hielo el precio tiene que ser 9 €.")
    public void unCocktailHieloTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.SEX_ON_THE_BEACH, false, 1, 1);
        assertEquals(9, coste);
    }

    @Test
    @DisplayName("Cuando pedimos un calimotxo el precio tiene que ser 6 €.")
    public void unCalimotxoTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.CALIMOTXO, false, 1, 0);
        assertEquals(6, coste);
    }
    
    @Test
    @DisplayName("Cuando pedimos un calimotxo con un hielo el precio tiene que ser 7 €.")
    public void unCalimotxoHieloTest() throws Exception {
        int coste = pub.calcularPrecio(Pub.CALIMOTXO, false, 1, 1);
        assertEquals(7, coste);
    }

    @Nested
    @DisplayName("Si es un cliente que es alumno")
    class Estudiantes {
        @Test
        @DisplayName("Cuando piden una cerveza, obtienen descuento")
        public void alumnoPideCervezaTest() throws Exception {
            int coste = pub.calcularPrecio(Pub.CERVEZA, true, 1, 0);
            assertEquals(4, coste);
        }

        @Test
        @DisplayName("Cuando alumnos piden mas de una cerveza, obtienen descuento.")
        public void alumnosPidenCervezasTest() throws Exception {
            int coste = pub.calcularPrecio(Pub.CERVEZA, true, 2, 0);
            assertEquals(8, coste);
        }

        @Test
        @DisplayName("Cuando piden un cocktail no tienen descuento")
        public void alumnoPideCocktailTest() throws Exception {
            int coste = pub.calcularPrecio(Pub.SEX_ON_THE_BEACH, true, 1, 0);
            assertEquals(8, coste);
        }
    }

    @Test
    @DisplayName("Cuando piden algo que no tenemos")
    public void bebidaDesconocidaTest() throws Exception {
        assertThrows(RuntimeException.class, () -> pub.calcularPrecio("angelShot", false, 1, 0));
    }

    @Nested
    @DisplayName("Cuando piden mas de dos bebidas")
    class BebidasMultiples {
        @Test
        @DisplayName("y son cocteles se les deniega")
        public void tresCoctelesTest() throws Exception {
            assertThrows(RuntimeException.class, () -> pub.calcularPrecio(Pub.SEX_ON_THE_BEACH, false, 3, 0));
        }

        @Test
        @DisplayName("y son cervezas")
        public void cincoCervezasTest() throws Exception {
            pub.calcularPrecio(Pub.CERVEZA, false, 5, 0);
        }
    }
}