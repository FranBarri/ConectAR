package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteoAplicacion {

	@Test
	void test() {
		fail("Not yet implemented");
	}
//    @Test
//    public void testCalcularCosto() {
//        Localidad localidad1 = new Localidad("Localidad1", 40.7128, -74.0060);
//        Localidad localidad2 = new Localidad("Localidad2", 34.0522, -118.2437);
//        Conexion conexion = new Conexion(localidad1, localidad2, 1.0, 10.0, 5.0);
//
//        double costoEsperado = 3934.0; // Calcula el costo esperado manualmente o utilizando una herramienta externa
//        double costoCalculado = conexion.calcularCosto();
//
//        assertEquals(costoEsperado, costoCalculado, 1e-6, "El costo calculado no coincide con el costo esperado");
//    }
//}

//    @Test
//    void testFind() {
//        int[] parent = new int[]{0, 1, 2, 3, 4};
//        assertEquals(0, Kruskal.find(parent, 0));
//        assertEquals(1, Kruskal.find(parent, 1));
//        assertEquals(2, Kruskal.find(parent, 2));
//        assertEquals(3, Kruskal.find(parent, 3));
//        assertEquals(4, Kruskal.find(parent, 4));
//    }
//
//    @Test
//    void testUnion() {
//        int[] parent = new int[]{0, 1, 2, 3, 4};
//        int[] rank = new int[]{0, 0, 0, 0, 0};
//
//        Kruskal.union(parent, rank, 0, 1);
//        assertEquals(0, Kruskal.find(parent, 1));
//
//        Kruskal.union(parent, rank, 2, 3);
//        assertEquals(2, Kruskal.find(parent, 3));
//
//        Kruskal.union(parent, rank, 1, 3);
//        assertEquals(0, Kruskal.find(parent, 3));
//    }

//    
//    void testArbolGeneradorMinimo() {
//        Localidad localidadA = new Localidad("A", 0, 0);
//        Localidad localidadB = new Localidad("B", 0, 1);
//        Localidad localidadC = new Localidad("C", 1, 0);
//        Localidad localidadD = new Localidad("D", 1, 1);
//
//        List<Localidad> localidades = Arrays.asList(localidadA, localidadB, localidadC, localidadD);
//
//        Conexion conexionAB = new Conexion(localidadA, localidadB, 1, 0, 0);
//        Conexion conexionAC = new Conexion(localidadA, localidadC, 1, 0, 0);
//        Conexion conexionAD = new Conexion(localidadA, localidadD, 1.5, 0, 0);
//        Conexion conexionBC = new Conexion(localidadB, localidadC, 1.5, 0, 0);
//        Conexion conexionBD = new Conexion(localidadB, localidadD, 1, 0, 0);
//        Conexion conexionCD = new Conexion(localidadC, localidadD, 1, 0, 0);
//
//        List<Conexion> conexiones = Arrays.asList(conexionAB, conexionAC, conexionAD, conexionBC, conexionBD, conexionCD);
//
//        List<Conexion> resultado = Kruskal.arbolGeneradorMinimo(localidades, conexiones);
//
//        assertEquals(3, resultado.size());
//        assertTrue(resultado.contains(conexionAB));
//        assertTrue(resultado.contains(conexionAC));
//        assertTrue(resultado.contains(conexionBD));
//    }
//}
}
