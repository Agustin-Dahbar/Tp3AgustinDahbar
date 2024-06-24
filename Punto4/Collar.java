package Punto4;

public class Collar 
{
	private NOMBRE_PERRO nombre;
	private boolean estaColgado;
	
	public Collar(NOMBRE_PERRO nombreNOMBRE_PERRO) 
	{
		this.nombre = nombreNOMBRE_PERRO;
		this.estaColgado = true;
	}
	
	//Getters 
	public NOMBRE_PERRO getNombre() 
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
