package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {

    public ArrayList<Conexion> calcularArbol(Grafo grafo) {
        ArrayList<Conexion> arbol = new ArrayList<>();
        ArrayList<Conexion> aristas = grafo.getAristas();
        Collections.sort(aristas, new Comparator<Conexion>() {
            public int compare(Conexion a1, Conexion a2) {
                return Double.compare(a1.getCosto(), a2.getCosto());
            }
        });

        ConjuntoDisjunto conjuntos = new ConjuntoDisjunto(grafo.getNumeroLocalidades());
        int numAristasAgregadas = 0;
        for (Conexion arista : aristas) {
            if (conjuntos.encontrar(arista.getOrigen().getId()) != conjuntos.encontrar(arista.getDestino().getId())) {
                arbol.add(arista);
                numAristasAgregadas++;
                if (numAristasAgregadas == grafo.getNumeroLocalidades() - 1) {
                    break;
                }
                conjuntos.unir(arista.getOrigen().getId(), arista.getDestino().getId());
            }
        }

        return arbol;
    }
}


