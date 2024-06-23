package Punto6;

public class Pelicula 
{
	private String nombre;
	private int año;
	private SERVICIOS servicio;
	
	public Pelicula(String nombre, int año, SERVICIOS servicio) 
	{
		this.nombre = nombre;
		this.año = año;
		this.servicio = servicio;
	}
	
	public SERVICIOS getServicio() 
	{
		return this.servicio;
	}
	
	public String getNombre() 
	{
		return this.nombre;
	}
	
}
