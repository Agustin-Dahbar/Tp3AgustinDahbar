package Punto6;
import java.util.ArrayList;

public class Cliente 
{
	private int dni;
	private String nombre;
	private double importeDeuda;
	private SERVICIOS servicio;
	private ArrayList<Pelicula> historialDePeliculas;
	
	public Cliente(int dni, SERVICIOS servicio) 
	{
		this.dni = dni;
		this.importeDeuda = 0;
		this.servicio = servicio;
		this.historialDePeliculas = new ArrayList<>();
	}
	
	public boolean esDeudor() 
	{
		return this.importeDeuda > 0;
	}
	
	public int getDni() 
	{
		return this.dni;
	}
	
	public SERVICIOS getServicio() 
	{
		return this.servicio;
	}
	
	public double getImporteDeuda() 
	{
		return this.importeDeuda;
	}
	
	public void agregarPeliculaAlHistorial(Pelicula pelicula) 
	{
		this.historialDePeliculas.add(pelicula);
	}
	
	public void aumentarDeuda(int deudaNueva) 
	{
		this.importeDeuda += deudaNueva;
	}
}
