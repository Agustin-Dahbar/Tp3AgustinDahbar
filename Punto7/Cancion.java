package Punto7;

public class Cancion 
{
	private String nombre;
	private String autor;
	private GENEROS genero;
	private int diasPublicacion;
	private int visitas;
	
	
	public Cancion(String nombre, String autor, GENEROS genero) 
	{
		this.nombre = nombre;
		this.autor = autor;
		this.genero = genero;
		this.diasPublicacion = 0;
		this.visitas = 0;
	}
	
	
	//Toda canción estará restringida para acceso sólo premium mientras no haya sido escuchada más de mil (1000)
	//veces o hayan pasado siete (7) días desde su publicación.
	public boolean esRestringida() 
	{
		return this.visitas < 1000 && diasPublicacion < 7;
	}
	
	public void incrementarVisitas() 
	{
		this.visitas++;
	}
	
	public String getNombre() 
	{
		return this.nombre;
	}
	
	public String getAutor() 
	{
		return this.autor;
	}
}
