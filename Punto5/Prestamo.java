package Punto5;
import java.util.Date; //Importamos la clase Date que contendrá fechas.

public class Prestamo 
{
	//Atributos
	private Date fechaRetiro;
	private Date fechaDevolucion;
	private Ejemplar ejemplar;
	
	//Constructor
	public Prestamo(Date fechaRetiro, Date fechaDevolucion, Ejemplar ejemplar) 
	{
		this.fechaRetiro = fechaRetiro;
		this.fechaDevolucion = fechaDevolucion;
		this.ejemplar = ejemplar;
	}
	
	public Date getFechaDevolucion() 
	{
		return this.fechaDevolucion;
	}
	
	public void setFechaDevolucion(Date fechaDevolucion) 
	{
		this.fechaDevolucion = fechaDevolucion;
	}
}
