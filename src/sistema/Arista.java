package sistema;

import gSon.Localidad;

public class Arista 
{
	//debe contener latitud y longitud?
	//faltaria sumar el costo fijo por provincia.
	private Localidad localidad1;
	private Localidad localidad2;
	private double costoTotal;
	
	public Arista(Localidad l1, Localidad l2)
	{
		localidad1 = l1;
		localidad2 = l2;
		costoTotal = calcularCosto();
	}
	
	public double calcularCosto()
	{
		return (localidad1.getLatitud() - localidad2.getLatitud())
				+ (localidad1.getLongitud() - localidad2.getLongitud());
	}

	public Localidad getLocalidad1() {
		return localidad1;
	}

	public Localidad getLocalidad2() {
		return localidad2;
	}

	public double getCostoTotal() {
		return costoTotal;
	}
	
	
	
}
