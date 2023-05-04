package sistema;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.*;

public class TestSistema {

	//Faltan tests extremos y casos felices
	
    @org.junit.jupiter.api.Test
    public void testCalcularCostoNoIgual() {
        Localidad localidad1 = new Localidad("Localidad1","Provincia1", 40.7128, -74.0060);
        Localidad localidad2 = new Localidad("Localidad2","Provincia2", 34.0522, -118.2437);
        Conexion conexion = new Conexion(localidad1, localidad2);

        double costoEsperado = 3934.0; // Calcula el costo esperado manualmente o utilizando una herramienta externa
        double costoCalculado = conexion.calcularCosto();

        assertNotEquals(costoEsperado, costoCalculado, 1e-6, "El costo calculado no coincide con el costo esperado");
    }
    
	@org.junit.jupiter.api.Test
    public void testArbolGeneradorMinimoContiene() {
        Localidad localidadA = new Localidad("A", "A", 0, 0);
        Localidad localidadB = new Localidad("B", "B", 0, 1);
        Localidad localidadC = new Localidad("C", "C", 1, 0);
        Localidad localidadD = new Localidad("D", "D", 1, 1);

        List<Localidad> localidades = Arrays.asList(localidadA, localidadB, localidadC, localidadD);

        // Crear conexiones con pesos (distancias, costos, etc.) entre localidades
        Conexion conexionAB = new Conexion(localidadA, localidadB);
        Conexion conexionAC = new Conexion(localidadA, localidadC);
        Conexion conexionAD = new Conexion(localidadA, localidadD);
        Conexion conexionBC = new Conexion(localidadB, localidadC);
        Conexion conexionBD = new Conexion(localidadB, localidadD);
        Conexion conexionCD = new Conexion(localidadC, localidadD);

        List<Conexion> conexiones = Arrays.asList(conexionAB, conexionAC, conexionAD, conexionBC, conexionBD, conexionCD);

        List<Conexion> resultado = Kruskal.arbolGeneradorMinimo(localidades, conexiones);

        assertEquals(3, resultado.size());
        assertTrue(resultado.contains(conexionAB));
        assertTrue(resultado.contains(conexionAC));
        assertTrue(resultado.contains(conexionCD));
    }
	
	@org.junit.jupiter.api.Test
    public void testCalcularDistanciaNoIgual() {
        Localidad localidad1 = new Localidad("Localidad1", "Provincia1", 40.7128, -74.0060);
        Localidad localidad2 = new Localidad("Localidad2", "Provincia2", 34.0522, -118.2437);
        Conexion conexion = new Conexion(localidad1, localidad2);

        double distanciaEsperada = 3934.0; // Calcula la distancia esperada manualmente o utilizando una herramienta externa
        double distanciaCalculada = conexion.calcularDistancia(localidad1.getLatitud(), localidad1.getLongitud(), localidad2.getLatitud(), localidad2.getLongitud());

        assertNotEquals(distanciaEsperada, distanciaCalculada, 1e-6, "La distancia calculada no coincide con la distancia esperada");
    }
}
