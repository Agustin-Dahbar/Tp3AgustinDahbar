package Punto4;

public class Collar 
{
	private PERROS nombre;
	private boolean estaColgado;
	
	public Collar(PERROS nombrePerro) 
	{
		this.nombre = nombrePerro;
		this.estaColgado = true;
	}
	
	//Getters 
	public PERROS getNombre() 
	{
		return this.nombre;
	}
	
	public boolean estaColgado() 
	{
		return this.estaColgado;
	}
	
	//Setters para colgar y descolgar el collar
	public void colgar() 
	{
		this.estaColgado = true;
	}
	
	public void descolgar() 
	{
		this.estaColgado = false;
	}
	
}
