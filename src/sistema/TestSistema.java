import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;

public class TestSistema {

    @Test
    public void testCalcularCosto() {
        Localidad localidad1 = new Localidad("Localidad1","Provincia1", 40.7128, -74.0060);
        Localidad localidad2 = new Localidad("Localidad2","Provincia2", 34.0522, -118.2437);
        Conexion conexion = new Conexion(localidad1, localidad2, 1.0, 10.0, 5.0);

        double costoEsperado = 3934.0; // Calcula el costo esperado manualmente o utilizando una herramienta externa
        double costoCalculado = conexion.calcularCosto();

        assertEquals(costoEsperado, costoCalculado, 1e-6, "El costo calculado no coincide con el costo esperado");
    }
    
    public void testArbolGeneradorMinimo() {
        Localidad localidadA = new Localidad("A", 0, 0);
        Localidad localidadB = new Localidad("B", 0, 1);
        Localidad localidadC = new Localidad("C", 1, 0);
        Localidad localidadD = new Localidad("D", 1, 1);

        List<Localidad> localidades = Arrays.asList(localidadA, localidadB, localidadC, localidadD);

        // Crear conexiones con pesos (distancias, costos, etc.) entre localidades
        Conexion conexionAB = new Conexion(localidadA, localidadB, 1);
        Conexion conexionAC = new Conexion(localidadA, localidadC, 1);
        Conexion conexionAD = new Conexion(localidadA, localidadD, 1.5);
        Conexion conexionBC = new Conexion(localidadB, localidadC, 1.5);
        Conexion conexionBD = new Conexion(localidadB, localidadD, 1);
        Conexion conexionCD = new Conexion(localidadC, localidadD, 1);

        List<Conexion> conexiones = Arrays.asList(conexionAB, conexionAC, conexionAD, conexionBC, conexionBD, conexionCD);

        List<Conexion> resultado = Kruskal.arbolGeneradorMinimo(localidades, conexiones);

        assertEquals(3, resultado.size());
        assertTrue(resultado.contains(conexionAB));
        assertTrue(resultado.contains(conexionAC));
        assertTrue(resultado.contains(conexionBD));
    }
    
    public void testCalcularDistancia() {
        Localidad localidad1 = new Localidad("Localidad1", 40.7128, -74.0060);
        Localidad localidad2 = new Localidad("Localidad2", 34.0522, -118.2437);
        Conexion conexion = new Conexion(localidad1, localidad2, 1);

        double distanciaEsperada = 3934.0; // Calcula la distancia esperada manualmente o utilizando una herramienta externa
        double distanciaCalculada = conexion.calcularDistancia();

        assertEquals(distanciaEsperada, distanciaCalculada, 1e-6, "La distancia calculada no coincide con la distancia esperada");
    }
}