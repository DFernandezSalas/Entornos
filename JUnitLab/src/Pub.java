public class Pub {
    public static final String CERVEZA = "ambar";
    public static final String VINO = "tinto";
    public static final String SIDRA = "ladron";
    public static final String SEX_ON_THE_BEACH = "sob";
    public static final String CALIMOTXO = "calimotxo";
    
    public static final int DESCUENTO_ESTUDIANTE = 1;
    public static final int PRECIO_HIELO = 1;
    
    public int calcularPrecio(String bebida, boolean estudiante, int cantidad, int hielo) {
        if (cantidad > 2 && esCoctel(bebida)) {
            throw new RuntimeException("Demasiadas bebidas, maximo 2");
        } else if (esCervezaConHielo(bebida, hielo)) {
        	throw new RuntimeException("La cerveza no puede llevar hielo");
        }
        int price;
        switch (bebida) {
            case CERVEZA : 
                price = 5;
                break;
            case VINO, SIDRA : 
                price = 2;
                break;
            case SEX_ON_THE_BEACH :
                price = calcularPrecioSexOnTheBeach();
                break;
            case CALIMOTXO :
                price = calcularPrecioCalimotxo();
                break;
            default :
                throw new RuntimeException("No tenemos de eso");
        };
        if (mereceDescuento(bebida, estudiante)) {
            price = price - DESCUENTO_ESTUDIANTE;
        }
        return precioConHielo(hielo, price) * cantidad;
    }

	private int precioConHielo(int hielo, int price) {
		return price + hielo * PRECIO_HIELO;
	}


	private boolean esCervezaConHielo(String bebida, int hielo) {
		return bebida.equals(CERVEZA) && hielo > 0;
	}

	private static boolean esCoctel(String bebida) {
        return bebida.equals(SEX_ON_THE_BEACH) || bebida.equals(CALIMOTXO);
    }

    private static boolean mereceDescuento(String bebida, boolean estudiante) {
        return estudiante && !esCoctel(bebida);
    }

    private static int calcularPrecioCalimotxo() {
        return precioCocaCola() + precioVino() * 2;
    }

    private static int calcularPrecioSexOnTheBeach() {
        return precioVodka() + (precioZumoDeNaranja() * 2) + precioGranadina();
    }

    private static int precioCocaCola() {
        return 2;
    }

    private static int precioVino() {
        return 2;
    }

    private static int precioZumoDeNaranja() {
        return 1;
    }

    private static int precioGranadina() {
        return 1;
    }

    private static int precioVodka() {
        return 5;
    }
}
