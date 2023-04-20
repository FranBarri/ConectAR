package sistema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Grafo
{
	// Representamos el grafo por su lista de vecinos.
	private ArrayList<TreeSet<Integer>> listaVecinos;
	
	/**La cantidad de vertices esta predeterminada desde el constructor
	 * */
	public Grafo(int vertices)
	{
		listaVecinos = new ArrayList<TreeSet<Integer>>();
		//un hashset para cada vertice.
		for (int i = 0; i < vertices; i++) {
			listaVecinos.add(new TreeSet<Integer>());
		}
	}
	
	/**Este agregado de aristas verifica los vertices
	 * y a continuacion, en caso que sean validos,
	 * tomara cada uno y les agregara (a su hashset)
	 * su vertice vecino, y viceversa.
	 * */
	public void agregarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		listaVecinos.get(i).add(j);
		listaVecinos.get(j).add(i);
	}
	
	// Eliminacion de aristas
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		listaVecinos.get(i).remove(j);
		listaVecinos.get(j).remove(i);
	}

	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return listaVecinos.get(i).contains(j);
	}

	// Cantidad de vertices
	public int tamano()
	{
		return listaVecinos.size();
	}
	
	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				ret.add(j);
		}
		
		return ret;		
	}
	
	public int grado(int i)
	{
		verificarVertice(i);
		return vecinos(i).size();
	}
	
	public ArrayList<Conexion> getAristas() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumeroLocalidades() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= tamano() )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}

}
