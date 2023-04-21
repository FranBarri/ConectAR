package sistema;

import java.util.List;

import sistema.Kruskal.*;

public class MainKruskal {
	// Ejemplo de uso
    public static void main(String[] args) {
        int V = 4;
        Arista[] edges = {
            new Arista(0, 1, 10),
            new Arista(0, 2, 6),
            new Arista(0, 3, 5),
            new Arista(1, 3, 15),
            new Arista(2, 3, 4)
        };
        List<Arista> result = Kruskal.kruskal(edges, V);
        System.out.println("Arbol de expansion minimo:");
        for (Arista edge : result) 
        {
            System.out.println(edge.toString());
        }
    }
}
