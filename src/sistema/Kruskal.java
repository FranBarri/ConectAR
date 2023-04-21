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

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
	private  int[]link;
	private Grafo graph;
	private ArrayList<Arista> listEdge;
	
	public Kruskal(Grafo g) {
		graph=g;
		listEdge= new ArrayList<Arista>();
		listEdge=g.getAristas();
	}
	
	private void initRoot() {
		link= new int[graph.Persons()];
		for (int j = 0; j < link.length; j++) {
			link[j]=j;
		}
	}
	
	//Determine if two persons are in the same connected component
	private int find(int i) {
		if (i== link[i]) {
			return i;
		}
		return link[i]= find(link[i]);
	}
	
	//Modify the structure of the trees
	private void union(int i, int j) {
		int rootI=find(i);
		int rootJ=find(j);
		link[rootI]=rootJ;
	}
	
	public Graph minimalGeneratorTree() {
		Collections.sort(listEdge);
		ArrayList<Edge> aux=new ArrayList<>();
		initRoot();
		int connectedComponent= graph.Persons();
		int position=0;
		while ((connectedComponent!=1 && position < graph.cantEdges())) {
			Edge current= listEdge.get(position);
			if (find(current.getPerson1().getId())!=find(current.getPerson2().getId())) {
				union(current.getPerson1().getId(), current.getPerson2().getId());
				aux.add(current);
				connectedComponent --;
			}
			 position++;
		}
		return new Graph(aux, graph.Persons());
	}
}


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
//        while (e < V - 1) {
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