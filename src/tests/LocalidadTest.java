package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import gSon.Localidad;

public class LocalidadTest 
{
	//test de localidad solo para corroborar ingreso de datos.
	private Localidad localidad;
	
	@Test(expected = IllegalArgumentException.class)
	public void localidadSinNombre() 
	{
		localidad = new Localidad(null, "Buenos Aires", 12, 15);
	}

	@Test(expected = IllegalArgumentException.class)
	public void localidadSinProvincia() 
	{
		localidad = new Localidad("UNGS", "", 12, 15);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void localidadLatitudNegativa() 
	{
		localidad = new Localidad("UNGS", "Buenos Aires", -12, 15);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void localidadSinLongitud() 
	{
		localidad = new Localidad("UNGS", "Buenos Aires", 12, 0);
	}
	
	@Test
	public void constructorLocalidadTest()
	{
		localidad = new Localidad("JCP", "Buenos Aires", 12, 15);
		assertTrue(localidad.getNombre().equals("JCP") 
				&& localidad.getProvincia().equals("Buenos Aires")
				&& localidad.getLatitud()>0
				&& localidad.getLongitud() == 15);
	}
}
