package sistema;

import java.lang.Math;
import java.math.BigDecimal;

import gSon.Localidad;

/**Haversine calcula la distancia en km desde una coordenada a otra, a partir de la latitud y longitud de cada coordenada.*/
public class FormulaHaversineArista 
{
	//siendo hav(angulo) = sen^2(angulo/2)
	//tenemos el radio promedio de la tierra, 6371km
	private Localidad localidad1, localidad2;
	private double radioTierra, distancia;
	
	public FormulaHaversineArista(Localidad l1, Localidad l2)
	{
		this.radioTierra = 6371;
		this.localidad1 = l1;
		this.localidad2 = l2;
		this.distancia = formulaHaversine();
	}
	
	public BigDecimal costoPesosPorKilometro()
	{
		//costo base.
		BigDecimal numero = new BigDecimal(String.valueOf(this.distancia));
		BigDecimal costo = new BigDecimal(numero.toBigInteger());
		BigDecimal porcentaje = new BigDecimal(0.5);
		BigDecimal costoFijo = new BigDecimal(500);
		
		//costo con porcentaje por superior a 300km.
		if(this.distancia > 300)
		{
			costo = costo.add(costo.multiply(porcentaje));
		}
		
		//costo por provincias distintas.
		if(localidad1.getProvincia() != localidad2.getProvincia())
		{
			costo = costo.add(costoFijo);
		}
		return costo;
	}
	/**Funcion Haversine:
	2 * R * arcsen[ raiz( hav(LAT2 - LAT1) + cos(LAT1) * cos(LAT2) * hav(LON2 - LON1) ) ]
	*/
	public double formulaHaversine()
	{	
		return Formula(Math.sqrt(cuentaRaiz()));
	}

	private double Formula(double valor)
	{
		return 2 * this.radioTierra * Math.asin(valor);
	}
	
	private double cuentaRaiz()
	{
		return Haversine(distanciaLatitud()) + 
				coseno(localidad1.getLatitud())*coseno(localidad2.getLatitud()) *
				Haversine(distanciaLongitud());
	}

	/**
	 * traducimos el valor de la funcion hav() = (seno(distanciaLat/2))^2 y (seno(distanciaLog/2))^2
	*/
	private static double Haversine(double valor) 
	{
		return Math.sin(valor/2) * Math.sin(valor/2);
	}

	private static double coseno(double valor)
	{
		return Math.cos(Math.toRadians(valor));
	}
	
	/**
	 * distancia en latitud y distancia en longitud, este valor debe ser medido en radianes.
	*/
	private double distanciaLatitud()
	{
		return Math.toRadians(localidad2.getLatitud() - localidad1.getLatitud());
	}
	
	/**
	 * distancia en latitud y distancia en longitud, este valor debe ser medido en radianes.
	*/
	private double distanciaLongitud()
	{
		return Math.toRadians(localidad2.getLongitud() - localidad1.getLongitud());
	}
	
	public double getDistancia()
	{
		return this.distancia;
	}
	
	@Override
	public String toString()
	{
		return "La distancia entre las dos coordenadas es " + getDistancia() + " km.";
	}
	
	public static void main(String[] args) 
	{
		double latuba = -34.59759446074721; // latitud de la primera coordenada
		double lonuba = -58.399152196372306; // longitud de la primera coordenada
		double latungs = -34.522736019048644; // latitud de la segunda coordenada
		double lonungs = -58.70047532995234; // longitud de la segunda coordenada
		
		Localidad uba = new Localidad("uba", "buenos aires", 0, 0);
		Localidad ungs = new Localidad("ungs", "buenos aires", 0, 0);
		uba.setLatitud(latuba);
		uba.setLongitud(lonuba);
		ungs.setLatitud(latungs);
		ungs.setLongitud(lonungs);
		
		FormulaHaversineArista fm = new FormulaHaversineArista(uba, ungs);
		System.out.println(fm.toString() + "\ncosto: " + fm.costoPesosPorKilometro());
	}
}