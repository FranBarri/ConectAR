package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gSon.Localidad;

/**Clase base de grafo para la implementación de las localidades y las conexiones.*/
public class Grafo {
	private int vertices;
	private List<Arista> listaDeAristas;
	private HashMap<Localidad, HashSet<Localidad>> vecinosDeLocalidades;
	//localidad y sus vecinos en estructuras separadas, para poder acceder a ellos con metodos get.

	/**Constructor base del grafo. su cantidad de vértices estará especificada por la cantidad de localidades que se carguen del gson.*/
	public Grafo()
	{
		this.vertices = cantidadVertices();
		//ya que estos serian todos los vertices que participan en el grafo.
		this.listaDeAristas = new ArrayList<>();
		//arraylist para acceder con los get por indice.
		this.vecinosDeLocalidades = new HashMap<Localidad, HashSet<Localidad>>();
		//hashSet para que no se repitan las localidades.
	}

	/**Dadas dos localidades (vértices) crea una arista entre ellas.*/
	public void agregarArista(Localidad localidad1, Localidad localidad2) 
	{
		//si no existe para uno no existe para el otro, pero para asegurar.
		if(!existeArista(localidad1, localidad2) && !existeArista(localidad2, localidad1))
		{
			agregarVecino(localidad1, localidad2);
			agregarVecino(localidad2, localidad1);
			this.listaDeAristas.add(new Arista(localidad1, localidad2));
		}
	}

	public void eliminarArista(Localidad localidad1, Localidad localidad2)
	{
		if(existeArista(localidad1, localidad2))
		{
			removerVecino(localidad1, localidad2);
			removerVecino(localidad2, localidad1);
			this.listaDeAristas.remove(new Arista(localidad1, localidad2));
		}
	}

	private boolean existeArista(Localidad l1, Localidad l2)
	{
		return this.listaDeAristas.contains(new Arista(l1, l2));
	}

	/**A la primer localidad se le agrega la segunda como vecino.
	 * con que agregue la primer localidad ya queda la segunda, no hace falta repetir.
	 * */
	private void agregarVecino(Localidad localidad1, Localidad localidad2)
	{
		if(!existeVecino(localidad1))
		{
			vecinosDeLocalidades.put(localidad1, new HashSet<Localidad>());
			vecinosDeLocalidades.get(localidad1).add(localidad2);
		}
		else vecinosDeLocalidades.get(localidad1).add(localidad2);
	}
	/**desaparece el lazo de ambas localidades en el listado de vecinos.*/
	private void removerVecino(Localidad localidad1, Localidad localidad2)
	{
		if(existeVecino(localidad1))
		{
			vecinosDeLocalidades.get(localidad1).remove(localidad2);
			vecinosDeLocalidades.get(localidad2).remove(localidad1);
		}
	}

	/**Comprueba si esta localidad está en el listado de vecinos.*/
	private boolean existeVecino(Localidad localidad)
	{
		return this.vecinosDeLocalidades.containsKey(localidad);
	}

	/**Vecinos de un vértice.*/
	public Set<Localidad> getVecinos(Localidad localidad)
	{
		Set<Localidad> ret = new HashSet<Localidad>();
		if(existeVecino(localidad))
		{
			ret = vecinosDeLocalidades.get(localidad);
		}
		return ret;
	}

	/**Cantidad de vecinos de esta localidad.*/
	public int grado(Localidad localidad)
	{
		return getVecinos(localidad).size();
	}

	/**Listado completo de aristas del grafo.*/
	public List<Arista> getAristas() 
	{
		return this.listaDeAristas;
	}

	/**Obtiene una arista particular.*/
	public Arista getArista(int i)
	{
		return getAristas().get(i);
	}

	public int cantidadAristas()
	{
		return getAristas().size();
	}

	/**Cantidad de vertices totales.*/
	public int cantidadVertices()
	{
		return this.vecinosDeLocalidades.size();
	}

	//    private void verificarVertice(Localidad localidad1)
	//    {
	//    	...
	//    }

	//    private void verificarDistintos(Localidad localidad1, Localidad localidad2)
	//    {
	//    	if(localidad1.equals(localidad2))
	//    	{
	//    		throw new IllegalArgumentException("No se permiten loops. ");
	//    	}
	//    }
}
