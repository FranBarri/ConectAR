package gSon;

public class Localidad {
    private String nombre;
    private String provincia;
    private double latitud;
    private double longitud;
    private int id;

    public Localidad(String nombre, String provincia, double latitud, double longitud,int id) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.latitud = latitud;
        this.longitud = longitud;
        this.id= id;
    }

    // Mtodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
