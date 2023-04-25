package sistema;

public class MainKruskal {
	// Ejemplo de uso
//    public static void main(String[] args) {
//        int V = 17;
////        Kruskal.Arista[] edges = {
////            new Kruskal.Arista(0, 1, 10),
////            new Kruskal.Arista(0, 2, 6),
////            new Kruskal.Arista(0, 3, 5),
////            new Kruskal.Arista(1, 3, 15),
////            new Kruskal.Arista(2, 3, 4)
////        };
//        
//        //simula al de la diapositiva
//        Kruskal.Arista[] aristas = {
//        	new Kruskal.Arista(1, 2, 4),//ab
//        	new Kruskal.Arista(2, 3, 8),//bc
//        	new Kruskal.Arista(3, 4, 6),//cd
//        	new Kruskal.Arista(4, 5, 9),//de
//        	new Kruskal.Arista(5, 6, 10),//ef
//        	new Kruskal.Arista(6, 7, 3),//fg
//        	new Kruskal.Arista(7, 8, 1),//gh
//        	new Kruskal.Arista(8, 9, 6),//hi
//        	
//        };
//        
//        List<Kruskal.Arista> result = Kruskal.kruskal(aristas, V);
//        System.out.println("Arbol de expansion minimo:");
//        for (Kruskal.Arista edge : result) 
//        {
//            System.out.println(edge.toString());
//        }
//    }
	
	public static void main(String[] args) {
//		int V = 7;  
//	    int E = 8;  
//	    Kruskal graph = new Kruskal(V, E);
//	    
////      //simula al de la diapositiva
////      Kruskal.Arista[] aristas = {
////      	new Kruskal.Arista(1, 2, 4),//ab
////      	new Kruskal.Arista(2, 3, 8),//bc
////      	new Kruskal.Arista(3, 4, 6),//cd
////      	new Kruskal.Arista(4, 5, 9),//de
////      	new Kruskal.Arista(5, 6, 10),//ef
////      	new Kruskal.Arista(6, 7, 3),//fg
////      	new Kruskal.Arista(7, 8, 1),//gh
////      	new Kruskal.Arista(8, 9, 6),//hi
////      	
////      };
//
//	    // add edge ab
//	    graph.edge[0].src = 1;
//	    graph.edge[0].dest = 2;
//	    graph.edge[0].weight = 4;
//	
//	    // add edge bc
//	    graph.edge[1].src = 2;
//	    graph.edge[1].dest = 3;
//	    graph.edge[1].weight = 8;
//	
//	    // add edge cd
//	    graph.edge[2].src = 3;
//	    graph.edge[2].dest = 4;
//	    graph.edge[2].weight = 6;
//	
//	    // add edge de
//	    graph.edge[3].src = 4;
//	    graph.edge[3].dest = 5;
//	    graph.edge[3].weight = 9;
//	
//	    // add edge ef
//	    graph.edge[4].src = 5;
//	    graph.edge[4].dest = 6;
//	    graph.edge[4].weight = 10;
//	    
//	    //add edge fg
//	    graph.edge[5].src = 6;
//	    graph.edge[5].dest = 7;
//	    graph.edge[5].weight = 3;
//	    
//	    //add edge gh
//	    graph.edge[6].src = 7;
//	    graph.edge[6].dest = 8;
//	    graph.edge[6].weight = 1;
//	    
//	    //add edge hi
//	    graph.edge[7].src = 8;
//	    graph.edge[7].dest = 9;
//	    graph.edge[7].weight = 6;
	    
	    int V = 4;  
        int E = 5;  
        Kruskal graph = new Kruskal(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;
	
	    graph.KruskalMST();
	}
}

