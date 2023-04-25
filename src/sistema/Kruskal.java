//como implementar kruskal junto a la clase aristas?

//package sistema;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Kruskal {
//
//    public ArrayList<Conexion> calcularArbol(Grafo grafo) {
//        ArrayList<Conexion> arbol = new ArrayList<>();
//        ArrayList<Conexion> aristas = grafo.getAristas();
//        Collections.sort(aristas, new Comparator<Conexion>() {
//            public int compare(Conexion a1, Conexion a2) {
//                return Double.compare(a1.getCosto(), a2.getCosto());
//            }
//        });
//
//        ConjuntoDisjunto conjuntos = new ConjuntoDisjunto(grafo.getNumeroLocalidades());
//        int numAristasAgregadas = 0;
//        for (Conexion arista : aristas) {
//            if (conjuntos.encontrar(arista.getOrigen().getId()) != conjuntos.encontrar(arista.getDestino().getId())) {
//                arbol.add(arista);
//                numAristasAgregadas++;
//                if (numAristasAgregadas == grafo.getNumeroLocalidades() - 1) {
//                    break;
//                }
//                conjuntos.unir(arista.getOrigen().getId(), arista.getDestino().getId());
//            }
//        }
//
//        return arbol;
//    }
//}


//package sistema;
//
//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class Kruskal {
//    
//    // Clase que representa una arista del grafo
//    static class Arista
//    {
//        int origen, destino, longitud;
//        Arista(int src, int dest, int weight) {
//            this.origen = src;
//            this.destino = dest;
//            this.longitud = weight;
//        }
//        
//        @Override
//        public String toString()
//        {
//        	return "destino " + origen + "-> " + destino;
//        }
//    }
//    
//    // Clase que representa un subconjunto de vértices del grafo
//    static class Subconjunto {
//        int parent, rank;
//        Subconjunto(int parent, int rank) {
//            this.parent = parent;
//            this.rank = rank;
//        }
//    }
//    
//    // Función para encontrar el subconjunto de un vértice dado
//    static int find(Subconjunto[] subsets, int i) {
//        if (subsets[i].parent != i) {
//            subsets[i].parent = find(subsets, subsets[i].parent);
//        }
//        return subsets[i].parent;
//    }
//    
//    // Función para unir dos subconjuntos en función de su rango
//    static void union(Subconjunto[] subsets, int x, int y) {
//        int xroot = find(subsets, x);
//        int yroot = find(subsets, y);
//        if (subsets[xroot].rank < subsets[yroot].rank) {
//            subsets[xroot].parent = yroot;
//        } else if (subsets[xroot].rank > subsets[yroot].rank) {
//            subsets[yroot].parent = xroot;
//        } else {
//            subsets[yroot].parent = xroot;
//            subsets[xroot].rank++;
//        }
//    }
//    
//    // Función principal para encontrar el árbol de expansión mínimo del grafo
//    static List<Arista> kruskal(Arista[] edges, int V) {
//        List<Arista> result = new ArrayList<>();
//        Subconjunto[] subsets = new Subconjunto[V];
//        for (int i = 0; i < V; i++) {
//            subsets[i] = new Subconjunto(i, 0);
//        }
//        Arrays.sort(edges, Comparator.comparingInt(e -> e.longitud));
//        int i = 0;
//        int e = 0;
//        while (e < V-1) {
//            Arista edge = edges[i++];
//            int x = find(subsets, edge.origen);
//            int y = find(subsets, edge.destino);
//            if (x != y) {
//                result.add(edge);
//                union(subsets, x, y);
//                e++;
//            }
//        }
//        return result;
//    }
//}

package sistema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import gSon.Localidad;

class Kruskal{
	class Edge implements Comparable<Edge> {
		public int src, dest, weight;

		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	};

	class subset
	{
		int parent, rank;
	};

	int V, E;    
	Edge edge[];
	public Kruskal(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i=0; i<e; ++i)
			edge[i] = new Edge();
	}
	int find(subset subsets[], int i)
	{
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}
	void Union(subset subsets[], int x, int y)
	{
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else
		{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
	// The main function to construct MST using Kruskal's algorithm
	void KruskalMST()
	{
		Edge result[] = new Edge[V];  
		int e = 0;  
		int i = 0; 
		for (i=0; i<V; ++i)
			Arrays.sort(edge);
		subset subsets[] = new subset[V];
		for(i=0; i<V; ++i)
			subsets[i]=new subset();
		for (int v = 0; v < V; ++v)
		{
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0; 
		while (e < V - 1)
		{
			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);
			if (x != y)
			{
				result[e++] = next_edge;
				Union(subsets, x, y);
			}

		}

		System.out.println("Following are the edges in " + 
				"the constructed MST");
		for (i = 0; i < e; ++i)
			System.out.println(result[i].src+" -- " + 
					result[i].dest+" == " + result[i].weight);
	}
	
//-----------------------------------------------------------------------
	
	public List<Arista> kruskal() {
		List<Arista> resultado = new ArrayList<>();

		// Crear un conjunto para cada vértice
		ConjuntoDisjunto conjuntoDisjunto = new ConjuntoDisjunto(vertices);

		// Ordenar las aristas por peso
		List<Arista> aristas = getAristas();
		Collections.sort(aristas);

		// Recorrer todas las aristas
		for (Arista a : aristas) {
			Localidad l1 = a.getLocalidad1();
			Localidad l2 = a.getLocalidad2();
			// Si los vértices no están en el mismo conjunto,
			// agregar la arista al resultado y unir los conjuntos
			if (!conjuntoDisjunto.estaConectado(l1, l2)) {
				resultado.add(a);
				conjuntoDisjunto.unir(l1, l2);
			}
		}

		return resultado;
	}
}